package com.example.demo.profile.controller;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("profile/*")
@RequiredArgsConstructor
public class Profile {

    private final ProfileService profileService;

    //기본정보 수정
    @GetMapping("getMyProfile")
    public String getMyProfile(@RequestParam("userId") String userId, Model model){
        ProfileDTO.GetMyProfileDTO getMyProfile = profileService.getMyProfile(userId);
        model.addAttribute("profile",getMyProfile);

        return "profile/updateProfile";


    }
}
