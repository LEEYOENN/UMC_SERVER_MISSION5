package umc.study.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewPreviewListDTO{

        @Builder.Default
        List<ReviewPreviewDTO> reviewList = new ArrayList<>(); // 기본값 설정
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO{
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
