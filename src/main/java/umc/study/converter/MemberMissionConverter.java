package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

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
}
