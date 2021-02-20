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
        System.out.println("=============================");
        System.out.println(password);

        if (memberDAO.findUserByUserPassword(paramMap) != null) {
            try {
                MimeMessage msg = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");

                StringBuffer emailContent = new StringBuffer();
                emailContent.append("<!DOCTYPE html>");
                emailContent.append("<html>");
                emailContent.append("<head>");
                emailContent.append("</head>");
                emailContent.append("<body>");
                emailContent.append(
                        "<div style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 500px; "                                  +
                                "           height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"	+
                                "   <h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"											+
                                "	    <span style=\"font-size: 15px; margin: 0 0 10px 3px;\">JackEmailSendTest</span><br />"								+
                                "	    <span style=\"color: #02b875\">비밀번호 찾기</span> 안내입니다."															+
                                "   </h1>\n"																												+
                                "   <p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"									+
                                userId+"님 안녕하세요.<br />"																			+
                                "   아래 <b style=\"color: #02b875\">'임시 비밀번호'</b> 를 사용하여 로그인 해주세요.<br /></p>"							+
                                "       <input style=\"color: #FFF; text-decoration: none; text-align: center; display: inline-block; border: none;"        +
                                "                   width: 210px; height: 45px; margin: 30px 5px 40px; background: #02b875;"                                +
                                "                   line-height: 45px; vertical-align: middle; font-size: 16px;\" type=\"submit\" value=\""+password+"\"/>"			+
                                "   </form>"                                                                                                                +
                                "   <div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>"														+
                                "</div>"
                );
                emailContent.append("</body>");
                emailContent.append("</html>");

                messageHelper.setSubject(userId + "님 비밀번호 찾기 메일입니다.");
                messageHelper.setText(emailContent.toString());
                messageHelper.setTo(email);
//                msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
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
