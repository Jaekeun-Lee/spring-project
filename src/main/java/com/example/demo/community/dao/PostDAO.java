package com.example.demo.community.dao;


import com.example.demo.community.vo.PostVO;

public interface PostDAO {

    //Post등록
    public void addPost(PostVO postVO);

    //포스트 상세조회
    public PostVO getPost(int postNo);



}
