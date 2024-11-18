package umc.study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.EntityGraph;

import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QRegion;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.QStore;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QStore store = QStore.store;

    @Override
    public Page<Mission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable){
        BooleanBuilder predicate = new BooleanBuilder();
        if(memberId != null){
            predicate.and(memberMission.member.id.eq(memberId));
        }
        if(status != null){
            predicate.and(memberMission.status.eq(status));
        }
        if(lastMissionId != null){
            predicate.and(mission.id.lt(lastMissionId));
        }
        List<Mission> content = jpaQueryFactory
                .selectFrom(mission)
                .join(memberMission).on(memberMission.mission.id.eq(mission.id))
                .join(mission.store, store).fetchJoin()
                .where(predicate)
                .orderBy(mission.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .join(memberMission).on(memberMission.mission.id.eq(mission.id))
                .where(predicate)
                .fetchOne();

        return new PageImpl<>(content, pageable, total != null ? total : 0L);
    }

    @Override
    public int findCompletedMissionsCountByMemberIdAndStatus(Long memberId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null){
            predicate.and(memberMission.member.id.eq(memberId));
        }
        if(status != null){
            predicate.and(memberMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch().size();
    }

    @Override
    public Page<Mission> findContinuingMissionsByMemberIdAndStatusAndRegionId(Long memberId, MissionStatus status, Long regionId, Long lastMissionId, Pageable pageable){
        BooleanBuilder predicate = new BooleanBuilder();

        if(regionId != null){
            predicate.and(mission.store.region.id.eq(regionId));
        }
        if(status != null){
            predicate.and(memberMission.status.eq(status));
        }
        // 3. 멤버가 참여하지 않은 미션 조건 추가
        predicate.and(
                jpaQueryFactory
                        .select(memberMission.id)
                        .from(memberMission)
                        .where(memberMission.member.id.eq(memberId)
                                .and(memberMission.mission.id.eq(mission.id)))
                        .notExists()
        );

        // 페이징된 데이터 조회
        List<Mission> content = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .where(predicate)
                .orderBy(mission.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        //전체 데이터 개수 조회
        Long total = jpaQueryFactory
                .select(mission.count())
                .from(mission)
                .join(mission.store, store)
                .where(predicate)
                .fetchOne();

        return new PageImpl<>(content, pageable, total != null ? total : 0L);
    }
}
