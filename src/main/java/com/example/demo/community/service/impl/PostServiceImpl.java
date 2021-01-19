package com.example.demo.community.service.impl;

import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
