package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

public interface MissionRepositoryCustom {
Page<Mission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable);
Page<Mission> findContinuingMissionsByMemberIdAndStatusAndRegionId
        (Long memberId, MissionStatus status, Long regionId, Long lastMissionId, Pageable pageable);
int findCompletedMissionsCountByMemberIdAndStatus(Long memberId, MissionStatus status);
}
