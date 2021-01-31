package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    public ResponseEntity<Object> signUpReq(@Valid MemberDTO.SignUpDTO param) {
        System.out.println(param.getName());

        return memberService.signUp(param) ? ResponseEntity.ok().body("회원이 되신걸 축하합니다.") :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버에 문제가 발생해 회원 가입에 실패 했습니다.");
    }

    @GetMapping("/logOut")
    public String logOutPage() {
        return "logOut";
    }

    @GetMapping("/member/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userId") String userId) {
        System.out.println(userId);
        return memberService.userIdCheck(userId);
    }
    @GetMapping("/member/emailCheck")
    @ResponseBody
    public int emailCheck(@RequestParam("email") String userId) {
        System.out.println(userId);
        return memberService.userIdCheck(userId);
    }


}

