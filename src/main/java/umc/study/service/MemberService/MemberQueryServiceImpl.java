package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
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
    private final MemberMissionRepository memberMissionRepository;

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

    @Override
    public Page<MemberMission> getMyChallengingMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> myMissionPage = memberMissionRepository.findByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page-1, 10));
        return myMissionPage;
    }
}
