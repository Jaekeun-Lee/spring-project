package com.example.demo.profile.controller;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class Profile {

    private final ProfileService profileService;

    //기본정보 조회
    @GetMapping("/getMyProfile")
    public String getMyProfile(@Valid ProfileDTO.GetMyProfileDTO param, Model model){


        return "getMyProfile";
    }
}
