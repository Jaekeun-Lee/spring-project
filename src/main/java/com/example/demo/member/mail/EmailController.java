package com.example.demo.member.mail;

import com.example.demo.member.service.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/findPassword1")
    public String emailPage() {

        return "findPassword1";
    }

    @GetMapping(value="/findPasswordReq")
    public ModelAndView sendEmailAction (@RequestParam Map<String, Object> paramMap, ModelMap model, ModelAndView mv) throws Exception {

        String USERNAME = (String) paramMap.get("username");
        String EMAIL = (String) paramMap.get("email");
        String PASSWORD = getTempPassword();
        memberDAO.findUserByUserPassword(paramMap);

        if (memberDAO.findUserByUserPassword(paramMap) != null) {
            try {
                MimeMessage msg = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");

                messageHelper.setSubject(USERNAME + "님 비밀번호 찾기 메일입니다.");
                messageHelper.setText("비밀번호는 " + PASSWORD + " 입니다.");
                messageHelper.setTo(EMAIL);
                msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(EMAIL));
                mailSender.send(msg);

            } catch (MessagingException e) {
                System.out.println("MessagingException");
                e.printStackTrace();
            }
            mv.setViewName("emailSuccess");
            return mv;
        }
        else {
            mv.setViewName("welcome");
            return mv;

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
    //TODO 비번 업데이트
    public void updatePassword(String str, String email) {
        String password = EncryptionUtils.encryptMD5(str);
        String id = memberDAO.findUserByUserId(email).getUserId();
        memberDAO.updateUserPassword(id, password);
    }

}
