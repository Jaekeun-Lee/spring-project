package com.example.demo.member.mail;

import com.example.demo.member.service.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    MemberDAO memberDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/findPassword1")
    public String emailPage() {

        return "member/manage/findPassword1";
    }

    @GetMapping(value = "/findPasswordReq")
    @ResponseBody
    public int sendEmailAction(@RequestParam Map<String, Object> paramMap) throws Exception {

        String userId = (String) paramMap.get("userId");
        String email = (String) paramMap.get("email");
        String password = getTempPassword();
        memberDAO.findUserByUserPassword(paramMap);

        paramMap.put("password",passwordEncoder.encode(password));
        memberDAO.updatePassword(paramMap);


        if (memberDAO.findUserByUserPassword(paramMap) != null) {
            try {
                MimeMessage msg = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");

                messageHelper.setSubject(userId + "님 비밀번호 찾기 메일입니다.");
                messageHelper.setText("비밀번호는 " + password + " 입니다.");
                messageHelper.setTo(email);
                msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
                mailSender.send(msg);

                return 1;
            } catch (MessagingException e) {
                e.printStackTrace();
                return 0;
            }

        } else {
            return 0;
        }
    }

    public String getTempPassword() {
        char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

}
