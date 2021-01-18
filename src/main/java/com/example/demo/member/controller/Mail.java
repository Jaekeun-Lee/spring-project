package com.example.demo.member.controller;

import com.example.demo.member.mail.MailHelper;
import com.example.demo.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

@Controller
@AllArgsConstructor

public class Mail {
    public JavaMailSender emailSender;

    @Autowired
    public MemberService memberservice;

    @RequestMapping("/signUp/id")
    public String test() throws MessagingException {
        MailHelper mailHelper = new MailHelper(emailSender);
        SimpleMailMessage message = new SimpleMailMessage();
        mailHelper.setTo("black7amanda@gmail.com");
        mailHelper.setFrom("twinkle7018@gmail.com");
        mailHelper.setSubject("ID찾기 test");

        String htmlContent = "<a href='www.google.com'> html 테스트입니다. </p>";  //메일에 html 형식 전송
        mailHelper.setText("테스트내용입니다." + htmlContent, true);   //메일 내용
        mailHelper.send();  //발송

        return "signUp";
    }
}
