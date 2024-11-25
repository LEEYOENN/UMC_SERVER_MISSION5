package umc.study.web.dto;

import lombok.*;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddResultDTO {
        Long missionId;
    }
//특정 가게의 미션목록 조회 dto
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        List<MissionResponseDTO.MissionPreViewDTO> missionList;
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
        Integer reward;
        String missionSpec;
        LocalDate deadLine;
        LocalDate createdAt;
    }

}
