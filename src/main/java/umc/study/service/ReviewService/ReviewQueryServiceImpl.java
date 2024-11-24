package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.RevieRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public void insertReview(Long memberId, Long storeId, String body, float score) {
        reviewRepository.dynamicQueryWithBooleanBuilder(memberId, storeId, body, score);
    }

    @Override
    public Review addReview(ReviewRequestDTO.AddDTO request){
        //가게 검증
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 id입니다."));
        //사용자 검증
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 id입니다."));

        //리뷰 엔티티 생성 그리고 저장
        Review review = ReviewConverter.toEntity(request, store, member);
        reviewRepository.save(review);

        return review;
    }

}
