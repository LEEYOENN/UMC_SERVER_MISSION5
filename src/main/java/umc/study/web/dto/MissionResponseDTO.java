package umc.study.web.dto;

import lombok.*;

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
