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

//        String username = request.getParameter(userId);
//        String password = request.getParameter(password);
//        String errormsg = null;
//        String errormsg = exception.getMessage();

        if (exception instanceof BadCredentialsException) { // 패스워드 불일치일때 발생한 예외
//
//            errormsg = MessageUtils.getMessage("error.BadCredentials");
//        } else if(exception instanceof InternalAuthenticationServiceException) {
//            errormsg = MessageUtils.getMessage("error.BadCredentials");
//        } else if(exception instanceof DisabledException) {
//            errormsg = MessageUtils.getMessage("error.Disaled");
//        } else if(exception instanceof CredentialsExpiredException) {
//            errormsg = MessageUtils.getMessage("error.CredentialsExpired");
//        }
//
//        request.setAttribute(userId, username);
//        request.setAttribute(password, password);
//        request.setAttribute(errormsgname, errormsg);
//
//        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
//    }


            String username =  request.getParameter("username");
            response.sendRedirect("/failLogin");

            //TODO 패스워드 실패 횟수를 체크해서 5회 이상이면, 비밀번호 재설정 페이지로 이동

            //TODO 패스워드 실패 카운드를 1개 증가

            //TODO ID 만 입력했을 경우

            //TODO 중복 체크

        }
    }
}


