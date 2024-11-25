package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMission toEntity(MemberMissionRequestDTO.AddDTO dto, Mission mission, Member member) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO.AddResultDTO toAddResponseDTO(MemberMission mission){
        return MemberMissionResponseDTO.AddResultDTO.builder()
                .memberMissionId(mission.getId())
                .missionId(mission.getMission().getId())
                .memberId(mission.getMember().getId())
                .build();
    }

    public static MemberMissionResponseDTO.MissionPreViewDTO toMissionPreviewDTO(MemberMission mission){
        return MemberMissionResponseDTO.MissionPreViewDTO.builder()
                .storeName(mission.getMission().getStore().getName())
                .status(mission.getStatus())
                .reward(mission.getMission().getReward())
                .missionSpec(mission.getMission().getMissionSpec())
                .build();

    }

    public static MemberMissionResponseDTO.MissionPreViewListDTO toMissionPreviewListDTO(Page<MemberMission> myMissionList){
        List<MemberMissionResponseDTO.MissionPreViewDTO> myMissionPreViewDTOList = myMissionList.stream()
                .map(MemberMissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MissionPreViewListDTO.builder()
                .missionList(myMissionPreViewDTOList)
                .listSize(myMissionList.getNumberOfElements())
                .totalPage(myMissionList.getTotalPages())
                .totalElements(myMissionList.getTotalElements())
                .isFirst(myMissionList.isFirst())
                .isLast(myMissionList.isLast())
                .build();
    }
}
