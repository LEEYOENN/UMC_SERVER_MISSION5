package umc.study.repository.RevieRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QReview;
import umc.study.domain.Review;
import umc.study.domain.QMember;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.domain.QStore;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory jpaqueryFactory;
    private final EntityManager em;
    private final QReview review = QReview.review;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;

    @Override
    public void dynamicQueryWithBooleanBuilder(Long memberId, Long storeId, String body, float score){

        BooleanBuilder predicate = new BooleanBuilder();
        if(memberId != null){
            predicate.and(member.id.eq(memberId));
        }
        if(storeId != null){
            predicate.and(store.id.eq(storeId));
        }
        if(body != null && !body.trim().isEmpty()){
            predicate.and(review.body.eq(body));
        }
        if(score >= 0){
            predicate.and(review.score.eq(score));
        }

        // 2. 리뷰 객체 생성 및 저장
        Review newReview = Review.builder()
                .member(em.getReference(Member.class, memberId))
                .store(em.getReference(Store.class, storeId))
                .body(body)
                .score(score)
                .build();
        em.persist(newReview);

    }
}
