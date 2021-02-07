package com.example.demo.community.controller;

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

//    public Community(PostService postService){
//        this.postService = postService;
//    }

    @Autowired
    @Qualifier("postServiceImpl")
    PostService postService;

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
        postService.addPost(postVO);

        model.addAttribute("post", postVO);

        return "welcome";
    }

    @PostMapping("/multi")
    public String upload(@RequestParam("files") List<MultipartFile> files)throws Exception {
        String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
        String basePath = rootPath + "/" + "multi";

        for (MultipartFile file : files){
            String originalName = file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;

            File destination = new File(filePath);
            file.transferTo(destination);
        }
        return "uploaded";

    }


    /*URI에  postNo 적고 검색(K,V)*/
    @GetMapping("getPost")
    public String getPost(@RequestParam("postNo") int postNo,
                          HttpSession httpSession,
                          Model model) throws Exception {
        PostVO postVO = postService.getPost(postNo);
        postVO.setUserId(((MemberVO)httpSession.getAttribute("user")).getUserId());
        System.out.println("postVO :" + postVO);
        model.addAttribute("postVO", postVO);
        return "post/getPost";
    }

//    @GetMapping("getPostList")
//    public String getPostList(@RequestParam("menu") String menu,
//                              @ModelAttribute("searchVO") SearchVO searchVO,
//                              Model model,
//                              HttpServletRequest req) throws Exception{
//        System.out.println("/getPostList GET");
//
//        HttpSession httpSession = req.getSession();
//        String authorization ="";
//        System.out.println("menu ::" + menu);
//
////        //검색완료후 페이징처리
////        searchVO.setPageSize(4);
////        //검색조건 임의설정
////        searchVO.setUserId("user02");
//
//
//        if (searchVO.getCurrentPage() != 0) {
//            if(searchVO.getCurrentPage()!=0 ){
//                if(menu == null){
//                    httpSession.getAttribute("menuType");
//                }
//            }else{
//                searchVO.setCurrentPage(1);
//                if(menu!=null){
//                    if(menu.equals("mange")){
//                        authorization = "manage";
//                    }else{
//                        authorization = "search";
//                    }
//                    httpSession.setAttribute("menuType", authorization);
//                }
//            }
//
//        }
////        searchVO.setPageSize(pageSize);
//
//        //business logic 수행 - map에 mapper에서 실행하고 나온 결과를 키밸류로 담고있음 (no로??)
//        Map<String,Object> map = postService.getPostList(searchVO);
//        System.out.println("searchVO::"+searchVO);
//
//        model.addAttribute("postList", map.get("list"));
//        model.addAttribute("searchVO",searchVO);
//        System.out.println("list");
//
//        return "post/getPostList";
//
//    }

    @GetMapping("getPostList")
    public String getPostList(@ModelAttribute("searchVO") SearchVO  searchVO,
                              HttpSession httpSession,
                              Model model)throws Exception{

        System.out.println("getPostList : GET");
        searchVO.setPageSize(20);
        searchVO.setUserId(((MemberVO) httpSession.getAttribute("user")).getUserId());
        if(searchVO.getCurrentPage() == 0 ){
            searchVO.setCurrentPage(1);
        }

        Map<String,Object> map = postService.getPostList(searchVO);
        System.out.println("searchVO::"+searchVO);

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
//        int postNo = postVO.getPostNo();
//        System.out.println(postNo);

        postService.updatePost(postVO);

        model.addAttribute("postVO", postVO);

        return "post/getPost";
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
