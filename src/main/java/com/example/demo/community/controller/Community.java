package com.example.demo.community.controller;

import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comm/*")
public class Community {

    @Autowired
    @Qualifier("postServiceImpl")
    private PostService postService;

    @GetMapping("addPost")
    public String addPostView(){
        return "post/addPost";
    }

    @PostMapping("addPost")
    public String addPost(@ModelAttribute PostVO postVO, HttpSession httpSession, Model model) {
        System.out.println("addPost컨트롤러::" +postVO);

//        데이터 임의세팅
        httpSession.setAttribute("userId","user02");
        postVO.setUserId((String) httpSession.getAttribute("userId"));
        postService.addPost(postVO);

        model.addAttribute("post", postVO);

        return "post/getPost";
    }

    @GetMapping("getPost")
    public String getPost(@RequestParam("postNo") int postNo, Model model){
        PostVO postVO = postService.getPost(postNo);

        model.addAttribute("post",postVO);
        return "post/getPost";
    }
//    @PostMapping("/addPost")
//    public String addPost(@ModelAttribute("post")PostVO postVO){
//        System.out.println(postVO);
//        return "Hello,world!";
//    }


//    private PostService postService;
//
//    public Community(){
//        System.out.println(this.getClass());
//    }
//
//    @RequestMapping(value ="/addPost", method= RequestMethod.GET)
//    public String addPost() throws Exception{
//        System.out.println("/addPost GET");
//        return "comm/addPost";
//    }

}


