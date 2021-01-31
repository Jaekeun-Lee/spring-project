package com.example.demo.common.controller;

import com.example.demo.member.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Welcome {

    @GetMapping("/welcome")
    public String welcomePage(Model model) {

        log.info("login user id : {}", SecurityUtils.getCurrentLoginUserId());
        log.info("login user id : {}", SecurityUtils.getLoginSessionMemberInfo());

//        model.addAttribute("userName", SecurityUtils.getLoginSessionMemberInfo().getUsername());

        return "welcome";
    }
}
