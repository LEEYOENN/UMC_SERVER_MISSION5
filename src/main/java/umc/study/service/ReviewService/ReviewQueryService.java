package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewQueryService {
    void insertReview(Long memberId, Long storeId, String body, float score);

    Review addReview(ReviewRequestDTO.AddDTO reviewRequestDTO);

}
