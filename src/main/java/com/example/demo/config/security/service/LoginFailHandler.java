package com.example.demo.config.security.service;

import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class LoginFailHandler implements AuthenticationFailureHandler {

    private final MemberService memberService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(exception instanceof UsernameNotFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            //TODO 어떤 메세지를 thymeleaf를 활용해 프론트에 메세지 노출..(등록된 아이디가 없습니다)

        }

        else if (exception instanceof BadCredentialsException) { // 패스워드 불일치일때 발생한 예외
            String username =  request.getParameter("username");

            // 패스워드 실패 횟수를 체크해서 5회 이상이면, 비밀번호 재설정 페이지로 이동
            int loginFailCount = memberService.getLoginFailCount(username);
            if (loginFailCount >= 5) {
                response.sendRedirect("/login/password/settings"); // TODO 해당 리퀘스트를 받는 컨트롤러를 만들기
            }

            //패스워드 실패 카운드를 1개 증가
            memberService.loginFailCountIncrease(username);

            //TODO 어떤 메세지를 thymeleaf를 활용해 프론트에 메세지 노출..(비밀번호가 틀렸습니다.)
        }

//        else if(exception instanceof BlockUserException) {
//
//        }

        //TODO 앞으로 추가되는 exception type에 따라 instanceof를 사용해서 핸들링 로직을 추가해주세요.

    }
}


