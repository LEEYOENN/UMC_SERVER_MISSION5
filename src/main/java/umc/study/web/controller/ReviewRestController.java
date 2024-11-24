package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")  // reviews 경로로 기본 매핑
public class ReviewRestController {

    @Autowired
    private ReviewQueryService reviewQueryService;

    @PostMapping("/")
    @Operation(summary = "리뷰 추가", description = "가게에 리뷰를 추가합니다.")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.AddDTO request) {

        Review response = reviewQueryService.addReview(request);

        return ApiResponse.onSuccess(ReviewConverter.toAddResponseDTO(response));
    }
}
