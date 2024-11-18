package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable) {
        return missionRepository.findMissionsByMemberIdAndStatus(memberId, status, lastMissionId, pageable);
    }

    @Override
    public int findCompletedMissionsCountByMemberIdAndStatus(Long memberId, MissionStatus status) {
        return missionRepository.findCompletedMissionsCountByMemberIdAndStatus(memberId, status);
    }

    @Override
    public Page<Mission> findContinuingMissionsByMemberIdAndStatusAndRegionId(Long memberId, MissionStatus status, Long regionId, Long lastMissionId, Pageable pageable) {
        return missionRepository.findContinuingMissionsByMemberIdAndStatusAndRegionId(memberId, status, regionId, lastMissionId, pageable);
    }

}
