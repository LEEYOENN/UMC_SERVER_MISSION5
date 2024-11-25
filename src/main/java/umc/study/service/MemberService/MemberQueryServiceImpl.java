package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.RevieRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Member findMemberById(Long id){
        Member foundedMember = memberRepository.dynamicQueryWithBooleanBuilder(id);
        System.out.println("Member: " + foundedMember);
        return foundedMember;
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> memberReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page-1, 10));
        return memberReviewPage;
    }
}
