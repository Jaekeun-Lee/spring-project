package com.example.demo.config.security.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof BadCredentialsException) { // 패스워드 불일치일때 발생한 예외
            //TODO 패스워드 실패 횟수를 체크해서 5회 이상이면, 비밀번호 재설정 페이지로 이동


            //TODO 패스워드 실패 카운드를 1개 증가


        }

    }
}
