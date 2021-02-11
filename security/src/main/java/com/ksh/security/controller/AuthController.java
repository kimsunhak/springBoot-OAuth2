package com.ksh.security.controller;


import com.ksh.security.payload.request.SignUpRequests;
import com.ksh.security.repository.MemberRepository;
import com.ksh.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;


@RequiredArgsConstructor
@RestController
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;

    private final MemberService memberService;

    @PostMapping("/api/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignUpRequests signUpRequests) {
        signUpRequests.setMemberPassword(passwordEncoder.encode(signUpRequests.getMemberPassword()));
        Long memberNo = memberService.signUpMember(signUpRequests);
        return ResponseEntity.created(URI.create("/api/member/" + memberNo)).build();
    }
}
