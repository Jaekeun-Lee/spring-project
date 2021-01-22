package com.example.demo.community.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.PostVO;

import java.util.List;
import java.util.Map;

public interface PostService {

    //게시물 등록
    public void addPost(PostVO postVO);

//    게시물 상세조회(postNo로 데이터 조인값 불러오기)
    public PostVO getPost(int postNo);

//    게시물 수정
    public void updatePost(PostVO postVO);

//    게시물 삭제
    public void deletePost(PostVO postVO);

//    게시물목록조회
    public Map<String, Object> getPostList(SearchVO searchVO);
//    public List<PostVO> getPostList(PostVO postVO);
}
