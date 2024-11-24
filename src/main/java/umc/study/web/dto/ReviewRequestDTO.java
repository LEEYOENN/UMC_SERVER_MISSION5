package umc.study.web.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddDTO {
        @NotNull(message = "가게 ID는 필수입니다.")
        private Long storeId;

        @NotNull(message = "작성자 ID는 필수입니다.")
        private Long memberId;

        @NotNull(message = "리뷰 내용은 필수입니다.")
        private String body;

        @NotNull(message = "평점은 필수입니다.")
        @DecimalMin(value = "0.0", message = "평점은 0.0 이상이어야 합니다.")
        @DecimalMax(value = "5.0", message = "평점은 5.0 이하여야 합니다.")
        private Float score;
    }
}
