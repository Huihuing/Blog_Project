package com.example.Blog_Project.Blog.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(String loginId, String password, String nickname, String email) {
        Member member = new Member();
        member.setLoginId(loginId);
        member.setPassword(password);
        member.setNickname(nickname);
        member.setEmail(email);
        member.setCreateDate(LocalDateTime.now());
        return memberRepository.save(member);
    }
}
