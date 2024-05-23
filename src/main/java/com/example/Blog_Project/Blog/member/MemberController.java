package com.example.Blog_Project.Blog.member;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Getter
    @Setter
    class MemberForm {
        @NotEmpty(message = "아이디를 입력하십시오.")
        private String loginId;
        @NotEmpty(message = "비밀번호를 입력하십시오.")
        private String password;
        @NotEmpty(message = "닉네임를 입력하십시오.")
        private String nickname;
        @NotEmpty(message = "이메일를 입력하십시오.")
        @Email(message = "이메일 형식에 맞춰 입력해주세요")
        private String email;
    }

    @GetMapping("/signup")
    public String signup(MemberForm memberForm) {return "signup_form";}
    @PostMapping("/signup")
    public String signup(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        memberService.save(memberForm.getLoginId(), memberForm.getPassword(), memberForm.getNickname(), memberForm.getEmail());
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login() {return "login_form";}
}
