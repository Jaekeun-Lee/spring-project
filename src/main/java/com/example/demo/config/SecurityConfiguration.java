package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 모든 리퀘스트에 대해 인증을 요구하는 설정
//        http.authorizeRequests(authorize -> {
//            authorize.mvcMatchers("/resources/**", "/login", "/", "/test/**", "/admin/**").permitAll()
//                    .mvcMatchers("/admin/**").hasRole("ADMIN")
//                    .mvcMatchers("/user/**", "/signUp/**", "/signUp2/**").hasRole("USER")
//                    .anyRequest().authenticated();
//        });



        http.formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
