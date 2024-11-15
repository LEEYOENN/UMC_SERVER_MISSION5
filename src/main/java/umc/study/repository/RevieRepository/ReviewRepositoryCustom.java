package umc.study.repository.RevieRepository;

import umc.study.domain.Review;
import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> dynamicQueryWithBooleanBuilder(String title, Long memberId, Long storedId, String body, Float score);
}
