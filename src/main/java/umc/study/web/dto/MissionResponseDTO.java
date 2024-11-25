package umc.study.web.dto;

import lombok.*;
import umc.study.domain.enums.MissionStatus;

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


}
