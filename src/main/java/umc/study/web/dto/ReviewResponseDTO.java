package umc.study.web.dto;

import lombok.*;

public class ReviewResponseDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDTO{
        Long reviewId;
        Long memberId;
    }
}
