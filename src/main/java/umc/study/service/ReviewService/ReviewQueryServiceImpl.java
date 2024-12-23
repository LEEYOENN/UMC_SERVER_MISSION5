package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import umc.study.aws.s3.AmazonS3Manager;
import umc.study.aws.s3.UuidRepository;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.Uuid;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.RevieRepository.ReviewImageRepository;
import umc.study.repository.RevieRepository.ReviewImageRepositoryImpl;
import umc.study.repository.RevieRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;
    private final ReviewImageRepository reviewImageRepository;
    @Override
    public void insertReview(Long memberId, Long storeId, String body, float score) {
        reviewRepository.dynamicQueryWithBooleanBuilder(memberId, storeId, body, score);
    }

    @Override
    public Review addReview(ReviewRequestDTO.AddDTO request, MultipartFile reviewPicture){
        //가게 검증
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 id입니다."));
        //사용자 검증
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 id입니다."));

        //리뷰 엔티티 생성 그리고 저장
        Review review = ReviewConverter.toEntity(request, store, member);

        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());
        String pictureUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), reviewPicture);

        reviewImageRepository.save(ReviewConverter.toReviewImage(pictureUrl, review));
        reviewRepository.save(review);

        return review;
    }

}
