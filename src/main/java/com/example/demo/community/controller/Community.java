package com.example.demo.community.controller;

import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comm/*")
public class Community {

    @Autowired
    @Qualifier("postServiceImpl")
    private PostService postService;

    @GetMapping("addPost")
    public String addPostView() {

        return "post/addPost";
    }

    @PostMapping("addPost")
    public String addPost(@ModelAttribute PostVO postVO, HttpSession httpSession, Model model) {
        System.out.println("addPost 컨트롤러::" + postVO);

//        데이터 임의세팅
        httpSession.setAttribute("userId", "user02");
        postVO.setUserId((String) httpSession.getAttribute("userId"));
        postService.addPost(postVO);

        model.addAttribute("post", postVO);

        return "post/getPost";
    }

    @GetMapping("getPost")
    public String getPost(@RequestParam("postNo") int postNo, Model model) {
        PostVO postVO = postService.getPost(postNo);

        model.addAttribute("post", postVO);
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
////        model.addAttribute("searchVO",searchVO);
//        System.out.println("list");
//
//        return "post/getPostList";
//
//    }

//    @GetMapping("getPostList")
//    public Map getPostList(@RequestParam("postNo")int postNo)throws Exception{
//        System.out.println("getPostList : GET");
//
//        Map<String,Object> map = new HashMap<String, Object>();
//
//        List<PostVO> postList = postService.getPostList()
//    }

    @GetMapping("updatePost")
    public String updatePostView(@RequestParam("postNo")int postNo,
                                 Model model)throws Exception {
        System.out.println("/updatePostView GET");

//        PostVO postVO = new PostVO();
//        postService.updatePost(postVO);

        return "post/updatePost";
    }

}
