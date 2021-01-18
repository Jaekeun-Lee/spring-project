package com.example.demo.community.dao.impl;

import com.example.demo.community.vo.PostVO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PostDAOImplTest {


    @Test
    void addPost(){
        //컨트롤러단에서넘어오는 정보랑 로직쓰면됨
        PostVO postVO = new PostVO();
        Date today = new Date();

        postVO.setPostNo();
        postVO.setPostName();
        postVO.setPostContent();
        postVO.setUserId();
        postVO.setRegDate(today);
        postVO.set



    }
}