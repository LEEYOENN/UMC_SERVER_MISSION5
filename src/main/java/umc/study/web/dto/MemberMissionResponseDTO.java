package umc.study.web.dto;

import lombok.*;

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
}
