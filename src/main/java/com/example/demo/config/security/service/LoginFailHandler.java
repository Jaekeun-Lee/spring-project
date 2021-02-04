package com.example.demo.config.security.service;

import com.example.demo.common.cd.ErrorCd;
import com.example.demo.common.dto.ErrorDTO;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginFailHandler implements AuthenticationFailureHandler {

    private final MemberService memberService;
    private final Environment environment;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof UsernameNotFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());

        } else if (exception instanceof BadCredentialsException) { // 패스워드 불일치일때 발생한 예외
            String username = request.getParameter("username");


            int loginFailCount = memberService.getLoginFailCount(username);
            if (loginFailCount >= 5) {

                response.sendRedirect("/login/password/settings"); // TODO 해당 리퀘스트를 받는 컨트롤러를 만들기
                return;
            }

            memberService.loginFailCountIncrease(username);

            request.getSession().setAttribute("Error", new ErrorDTO(ErrorCd.WRONG_PASSWORD));
            response.sendRedirect("/login");
//        else if(exception instanceof BlockUserException) {
//
//        }

            //TODO 앞으로 추가되는 exception type에 따라 instanceof를 사용해서 핸들링 로직을 추가해주세요.

        }
    }
}


