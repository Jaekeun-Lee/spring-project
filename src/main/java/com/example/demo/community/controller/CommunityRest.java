package com.example.demo.community.controller;

import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import com.example.demo.community.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public String addReply(@RequestBody ReplyVO replyVO){

        String sessionId = "user02";
        replyVO.setReplyUserId(sessionId);

        return "success";
    }


}
