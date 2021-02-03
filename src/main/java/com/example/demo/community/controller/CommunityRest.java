package com.example.demo.community.controller;

import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/comm")
@Slf4j
public class CommunityRest {

    @Autowired
    @Qualifier("postServiceImpl")
    private PostService postService;

    public CommunityRest(PostService postService){
        log.info("::"+getClass().getName()+"Start::");
        this.postService = postService;
    }

    @PostMapping("/addReply")
    public ReplyVO addReply(@RequestBody ReplyVO replyVO,
                           HttpSession httpSession){
        String sessionId = "user94";
        replyVO.setReplyUserId(sessionId);

//        replyVO.setReplyUserId(((MemberVO) httpSession.getAttribute("user")).getUserId());

//        postService.addReply(replyVO);

        return postService.addReply(replyVO);
    }


}
