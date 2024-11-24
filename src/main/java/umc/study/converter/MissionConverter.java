package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static Mission toEntity(MissionRequestDTO.AddDTO dto, Store store){
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission){
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }
}
