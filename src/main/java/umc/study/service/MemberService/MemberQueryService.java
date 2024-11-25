package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;

public interface MemberQueryService {
    Member findMemberById(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);

    Page<MemberMission> getMyChallengingMissionList(Long memberId, Integer page);
}
