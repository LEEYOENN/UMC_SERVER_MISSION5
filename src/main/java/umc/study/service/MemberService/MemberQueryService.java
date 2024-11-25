package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;

public interface MemberQueryService {
    Member findMemberById(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);

}
