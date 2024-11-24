package umc.study.service.MemberService;

import umc.study.web.dto.MemberRequestDTO;
import umc.study.domain.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
