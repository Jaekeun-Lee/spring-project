package com.example.demo.community.service.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("postServiceImpl")
public class PostServiceImpl implements PostService {

    @Autowired
    @Qualifier("postDAOImpl")
    PostDAO postDAO;
    public void setPostDAO(PostDAO postDAO){
        System.out.println("PostServiceImpl::"+getClass()+".postDAOImpl call:::");
        this.postDAO = postDAO;
    }

    public PostServiceImpl() {
        System.out.println("PostServiceImpl::"+getClass()+".dafault Constructor Call:::");

    }

    @Override
    public void addPost(PostVO postVO){
        postDAO.addPost(postVO);

    }

    @Override
    public PostVO getPost(int postNo) {
        return postDAO.getPost(postNo);
    }

    @Override
    public void updatePost(PostVO postVO){

        postDAO.updatePost(postVO);
    }

    @Override
    public void deletePost(PostVO postVO){

        postDAO.deletePost(postVO);
    }

//    @Override
//    public Map<String,Object> getPostList(SearchVO searchVO){
//        List<PostVO> list = postDAO.getPostList(searchVO);
//        int totalcount = postDAO.getTotalCount(searchVO);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("list", list);
//        map.put("totalCount", new Integer(totalcount));
//        return map;
//    }
    @Override
    public List<PostVO> getPostList(PostVO postVO){
        return postDAO.getPostList(postVO);
    }
}
