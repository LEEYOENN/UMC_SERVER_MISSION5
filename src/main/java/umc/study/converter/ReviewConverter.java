package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;


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
}