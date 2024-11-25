package umc.study.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public MemberMission challengeMission(MemberMissionRequestDTO.AddDTO request){
        //미션 있는지 검증
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게 Id입니다."));
        //멤버 검증
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멤버 Id 입니다."));

        //MemberMission 엔티티 생성과 저장
        MemberMission memberMission = MemberMissionConverter.toEntity(request, mission, member);
        memberMissionRepository.save(memberMission);

        return memberMission;
    }

}
