package com.example.demo.profile.controller;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import com.sun.mail.imap.Rights;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("profile/*")
@RequiredArgsConstructor
public class Profile {

    @Autowired
    private final ProfileService profileService;

    //기본정보 등록
    @GetMapping("addMyProfile")
    public String addMyProfileView(@RequestParam("userId") String userId, Model model){
        ProfileDTO.GetMyProfileDTO getMyProfile = profileService.getMyProfile(userId);
        model.addAttribute("profile",getMyProfile);
        return "profile/addMyProfile";
    }
    @PostMapping("addMyProfile")
    public String addMyProfile(@ModelAttribute ProfileDTO.UpdateMyProfileDTO param, HttpSession session, Model model){
        param.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
        profileService.updateMyProfile(param);
        model.addAttribute("profile",profileService.getMyProfile(param.getUserId()));
        return "profile/getMyProfile";
    }

    //기본정보 조회
    @GetMapping("getMyProfile")
    public String getMyProfile(@RequestParam("userId") String userId, Model model){
        ProfileDTO.GetMyProfileDTO getMyProfile = profileService.getMyProfile(userId);
        model.addAttribute("profile",getMyProfile);
        return "profile/getMyProfile";
    }

    //북마크 목록조회
    @GetMapping("getBookmarkList")
    public String getBookmarkList(HttpSession session, Model model){
        String sessionId = ((MemberVO)session.getAttribute("user")).getUserId();
        List<BookmarkVO> bookmarkList = profileService.getBookmarkList(sessionId);
        model.addAttribute("bookmarkList", bookmarkList);
        for(BookmarkVO bookmarkVO : bookmarkList){
            System.out.println(bookmarkVO);
        }
        return "profile/getBookmarkList";
    }

    //리뷰 목록 조회
    @GetMapping("getReviewList")
    public String getReviewList(HttpSession session, Model model){
        session.setAttribute("userId",2);
        List<ReviewVO> reviewList = profileService.getReviewList((int)session.getAttribute("userId"));
//        List<ReviewVO> reviewList = profileService.getReviewList(((MemberVO)session.getAttribute("user")).getUserId());
        model.addAttribute("reviewList",reviewList);
        return "profile/getReviewList";
    }
}
