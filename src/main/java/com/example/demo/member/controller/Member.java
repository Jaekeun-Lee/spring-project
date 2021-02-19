package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class Member {

    private final MemberService memberService;

    /**
     * 로그인 페이지
     *
     * @return
     */

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/signUp")
    public String signUpPage() {
        return "signUp";
    }

    // 회원 가입 요청
    @PostMapping("/signUp")
    public String signUpReq(@Valid MemberDTO.SignUpDTO param) {
        if (memberService.signUp(param)) {
            return "/login";
        }else{
            return "/signUp";
        }
    }

    @GetMapping("/member/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userId") String userId) {
        return memberService.userIdCheck(userId);
    }

    @GetMapping("/login/password/settings")
    public String changePassword() {
        return "member/manage/findPassword1";
    }


}

