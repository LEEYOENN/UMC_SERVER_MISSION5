package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "리뷰 추가", description = "가게에 리뷰를 추가합니다.")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> addReview(@Parameter(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
                                                                     @RequestPart("request") @RequestBody @Valid ReviewRequestDTO.AddDTO request,
                                                                 @RequestPart("reviewPicture")MultipartFile reviewPicture) {

        Review response = reviewQueryService.addReview(request, reviewPicture);

        return ApiResponse.onSuccess(ReviewConverter.toAddResponseDTO(response));
    }
}
