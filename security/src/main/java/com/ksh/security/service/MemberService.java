package com.ksh.security.service;

import com.ksh.security.domain.AuthProvider;
import com.ksh.security.domain.Member;
import com.ksh.security.domain.Role;
import com.ksh.security.exception.AuthException;
import com.ksh.security.exception.ErrorCode;
import com.ksh.security.payload.request.SignUpRequests;
import com.ksh.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long signUpMember(SignUpRequests signUpRequests) {
        if (memberRepository.existsByMemberEmail(signUpRequests.getMemberEmail())) {
            throw new AuthException(ErrorCode.DUPLICATED_EMAIL);
        }

        Member member = new Member();
        member.setMemberName(signUpRequests.getMemberName());
        member.setMemberEmail(signUpRequests.getMemberEmail());
        member.setMemberPassword(signUpRequests.getMemberPassword());
        member.setMemberPhone(signUpRequests.getMemberPhone());
        member.setProvider(AuthProvider.local);
        member.setRole(Role.ROLE_USER);

        return memberRepository.save(member).getMemberNo();
    }

}
