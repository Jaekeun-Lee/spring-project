package com.example.demo.profile.controller;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/restProfile/*")
public class ProfileRest {

        @Autowired
        ProfileService profileService;


        @GetMapping("deleteBookmarkList")
        public int deleteBookmarkList(@ModelAttribute BookmarkVO bookmarkVO, HttpSession session){
            bookmarkVO.setUserId(((MemberVO)session.getAttribute("userId")).getUserId());
            int result = profileService.deleteBookmark(bookmarkVO);
            /*result 값은 Rest컨트롤러에 alert(data)에서 data에 해당됨*/
        return result;
        }


}
