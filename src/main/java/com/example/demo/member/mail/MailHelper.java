package com.example.demo.member.mail;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

public class MailHelper {

        public JavaMailSender sender;
        public MimeMessage message;
        public MimeMessageHelper messageHelper;

        public MailHelper(JavaMailSender sender) throws MessagingException {
            this.sender = sender;
            message = sender.createMimeMessage();
            messageHelper = new MimeMessageHelper(message, true, "utf-8");
        }

        public void setFrom(String fromEmail) throws MessagingException { //발송자 메일
            messageHelper.setFrom(fromEmail);
        }

        public void setTo(String email) throws MessagingException {  //수신자 메일
            messageHelper.setTo(email);
        }

        public void setText(String text, boolean useHtml) throws MessagingException {    //메일 내용
            messageHelper.setText(text, useHtml);
        }

        public void setSubject(String subject) throws MessagingException {  //메일 제목
            messageHelper.setSubject(subject);
        }

        public void setInline(String contentId, String pathToInline) throws MessagingException, IOException {   //첨부파일
            File file = new ClassPathResource(pathToInline).getFile();
            FileSystemResource fsr = new FileSystemResource(file);

            messageHelper.addInline(contentId, fsr);
        }

        public void send() { //전송
            try {
                sender.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

