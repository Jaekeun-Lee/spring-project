package com.example.demo.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * spring security에 전반적인 설정을 셋팅하는 설정 클래스 정의
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/resources/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        // 모든 리퀘스트에 대해 인증을 요구하는 설정
        http.authorizeRequests(authorize -> {

            // 로그인 관련 페이지는 권한 없는 유저도 사용할 수 있어야 함(비로그인 상태 유저도 가능해야함)
            authorize.antMatchers("/login/**", "/signUp").anonymous();

            // start uri 에 따라 필요한 권한 설정
            authorize
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER");
        });


        http.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .loginPage("/login") // 로그인 페이지 설정
                .usernameParameter("username") // 로그인 페이지의 id에 해당하는 부분의 name attribute
                .passwordParameter("password") // 로그인 페이지의 password에 해당하는 부분의 name attribute
                .loginProcessingUrl("/login/req") // 로그인 요청시 사용하는 uri(로그인 페이지의 로그인 요청 버튼의 uri 임)
        ;

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);

        http.exceptionHandling()
                .accessDeniedPage("/main"); // 권한이 없는 사용자가 접근했을 경우 이동할 경로를 지정
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
