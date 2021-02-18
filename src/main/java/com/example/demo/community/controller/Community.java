package com.example.demo.community.controller;

import com.example.demo.common.service.FileUploadService;
import com.example.demo.common.vo.FileVO;
import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comm/*")
@Slf4j
public class Community {

    public Community(PostService postService) {
        log.info(":: " + getClass().getName() + " Start::");
        this.postService = postService;
    }

    @Autowired
    @Qualifier("postServiceImpl")
    PostService postService;

    @Autowired
    @Qualifier("fileUploadServiceImpl")
    private FileUploadService fileUploadServiceImpl;

    @GetMapping("addPost")
    public String addPostView() {

        return "post/addPost";
    }

    @PostMapping("addPost")
    public String addPost(@ModelAttribute PostVO postVO, HttpSession httpSession, Model model) {
        System.out.println("addPost 컨트롤러::" + postVO);

//        데이터 임의세팅
//        httpSession.setAttribute("userId", "user01");
        postVO.setUserId(((MemberVO)httpSession.getAttribute("user")).getUserId());
        int postNo = postService.addPost(postVO);

        PostVO resultPostVO = postService.getPost(postNo);
        model.addAttribute("post", resultPostVO);

        return "redirect:/comm/getPost?postNo="+postNo;
    }



    /*URI에  postNo 적고 검색(K,V)*/
    @GetMapping("getPost")
    public String getPost(@RequestParam("postNo") int postNo,
                          HttpSession httpSession,
                          Model model) throws Exception {

        PostVO postVO = postService.getPost(postNo);
        PostVO postVO1 = new PostVO();
        postService.plusViewCnt(postNo);
        System.out.println("postVO :" + postVO);
        model.addAttribute("postVO", postVO);
        model.addAttribute("postVO1", postVO1);
        return "post/getPost";
    }


    @GetMapping("getPostList")
    public String getPostList(@ModelAttribute("searchVO") SearchVO searchVO,
                              Model model)throws Exception{

        searchVO.setPageSize(10);
        if(searchVO.getCurrentPage() == 0 ){
            searchVO.setCurrentPage(1);
        }

        Map<String,Object> map = postService.getPostList(searchVO);

        model.addAttribute("postList",map.get("list"));

        return "post/getPostList";

    }


    @GetMapping("updatePost")
    public String updatePostView(@RequestParam("postNo")int postNo,
                                 Model model)throws Exception {
        System.out.println("/updatePostView GET");

        PostVO postVO = postService.getPost(postNo);

        model.addAttribute("postVO",postVO);

        return "post/updatePost";
    }

    @PostMapping("updatePost")
    public String updatePost(@ModelAttribute  PostVO postVO,
                             HttpSession httpSession,
                             Model model) throws Exception{
        System.out.println("/updatePost POST");
        httpSession.setAttribute("userId","user01");
        postVO.setUserId((String)httpSession.getAttribute("userId"));

        postService.updatePost(postVO);

        return "redirect:/comm/getPost?postNo="+postVO.getPostNo();

    }

    @GetMapping("deletePost")
    public String deletePost(@RequestParam("postNo") int postNo
//                            @RequestParam("postNo") PostVO postVO
//                             @ModelAttribute PostVO postVO,
//                             HttpSession httpSession
//                             Model model
    ){
        System.out.println("/deletePost GET");
        postService.deletePost(postNo);

//        httpSession.setAttribute("userId", "user05");
//        postVO.setUserId((String)httpSession.getAttribute("userId"));
//        postVO.setUserId(((MemberVO) httpSession.getAttribute("user")).getUserId());


        return "redirect:/comm/getPostList";
    }

//    @GetMapping("detail")

}
