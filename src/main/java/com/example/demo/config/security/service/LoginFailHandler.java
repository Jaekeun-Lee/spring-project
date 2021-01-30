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

    /**
     * 1. AuthenticationException에 담긴 에러 정보를 받아서 request의 Attribute속성에 추가하여 화면에 출력
     * 2. 에러 정보에 대한 메시지는 MessageSource를 사용하여 properties를 사용한 에러 메시지를 출력
     * 3. 로그인 실패한 계정의 실패 횟수를 증가시켜 줄 것 ( update )
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof UsernameNotFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());

        } else if (exception instanceof BadCredentialsException) { // 패스워드 불일치일때 발생한 예외
            String username = request.getParameter("username");


            int loginFailCount = memberService.getLoginFailCount(username);
            if (loginFailCount >= 5) {
                //changePassword.html 리다이렉트
                response.sendRedirect("/login/password/settings"); // TODO 해당 리퀘스트를 받는 컨트롤러를 만들기
                return;
            }
            // 패스워드 실패 카운드를 1개 증가
            memberService.loginFailCountIncrease(username);

            request.getSession().setAttribute("error", new ErrorDTO(ErrorCd.WRONG_PASSWORD));
            response.sendRedirect("/login");
//        else if(exception instanceof BlockUserException) {
//
//        }

            //TODO 앞으로 추가되는 exception type에 따라 instanceof를 사용해서 핸들링 로직을 추가해주세요.

        }
    }
}


