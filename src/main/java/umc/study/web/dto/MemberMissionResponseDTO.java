package umc.study.web.dto;

import lombok.*;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public class MemberMissionResponseDTO {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddResultDTO {
        Long memberMissionId;
        Long memberId;
        Long missionId;
    }
    // 내가 진행중/진행완료인 미션 목록
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {

        List<MissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDTO {
        String storeName;
        MissionStatus status;
        Integer reward;
        String missionSpec;
    }
}
