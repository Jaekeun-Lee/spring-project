package com.example.demo.community.dao.impl;

import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDAOImplTest {

    @Autowired
    @Qualifier("postServiceImpl")
    private PostService postService;

    public PostDAOImplTest(){
        System.out.println("TEST APP:::::");
    }


    @Test
    public void addPost(){
        //컨트롤러단에서넘어오는 정보랑 로직쓰면됨
        PostVO postVO = new PostVO();
        Date today = new Date();

        postVO.setPostNo(3);
        postVO.setPostName("범내려온다");
        postVO.setPostContent("범이내려온다");
        postVO.setUserId("user03");
        postVO.setRegDate(today);
        postVO.setReplyCnt(3);
        postVO.setViewCnt(4);


//        Assert.assertEquals("user02",postVO.getPostNo());


    }
}