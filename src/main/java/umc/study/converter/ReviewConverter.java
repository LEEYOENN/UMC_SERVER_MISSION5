package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO.AddDTO dto, Store store, Member member) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.AddResultDTO toAddResponseDTO(Review review){
        return ReviewResponseDTO.AddResultDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();

    }

    public static ReviewResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}