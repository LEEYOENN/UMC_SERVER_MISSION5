package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
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

    @Override
    public Mission addMission(MissionRequestDTO.AddDTO request) {

        // Store가 존재하는지 검증
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게 Id 입니다."));

        Mission mission = MissionConverter.toEntity(request, store);
        missionRepository.save(mission);

        return mission;

    }
}
