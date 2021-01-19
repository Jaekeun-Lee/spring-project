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

        postVO.setPostNo(4);
        postVO.setPostName("hihihi");
        postVO.setPostContent("hihello");
        postVO.setUserId("user04");
        postVO.setRegDate(today);
        postVO.setReplyCnt(2);
        postVO.setViewCnt(1);

        postService.addPost(postVO);
        PostVO postVO1 = postService.getPost(4);
//        postVO = postService.getPost(4);
        Assert.assertEquals("user03",postVO1.getUserId());
//ㅅㅂ
    }

    @Test
    public void getPost(){

        PostVO postVO = new PostVO();
        postVO = postService.getPost(1);
        System.out.println("getPost() TEST::"+postVO);

//        Assert.assertEquals("java", postVO.getPostName());
//        Assert.assertEquals(1, postVO.getPostReply().get(0).getReplyNo());
//        Assert.assertEquals(2, postVO.getPostReply().size());
//        Assert.assertEquals(2, postVO.getReplyCnt());
        }


//        Assert.assertEquals("user02",postVO.getPostNo());

    @Test
    public void updatePost(){

        PostVO postVO = new PostVO();
        Date today = new Date();

        postVO.setPostNo(2);
        postVO.setPostName("java");
        postVO.setPostContent("업데이트테스트");
        postVO.setRegDate(today);

        postService.updatePost(postVO);
        PostVO postVO1 = postService.getPost(2);

        Assert.assertEquals(2,postVO1.getPostNo());
    }

}