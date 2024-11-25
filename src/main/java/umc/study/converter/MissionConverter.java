package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    ///미션추가 관리 컨버터 addRequestDto->mission
    public static Mission toEntity(MissionRequestDTO.AddDTO dto, Store store){
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }
    ///미션추가 관리 컨버터 mission->responseDto
    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission){
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }

    //미션프리뷰dto로 마꾸는 컨버터
    public static MissionResponseDTO.MissionPreViewDTO toMissionPreviewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadLine(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();

    }
    //페이지를 미션dto리스트로 바꾸는 컨버터
    public static MissionResponseDTO.MissionPreViewListDTO toMissionPreviewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .missionList(missionPreViewDTOList)
                .listSize(missionPreViewDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .build();
    }

}
