package com.example.demo.community.dao.impl;

import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.vo.PostVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PostDAOImpl implements PostDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    @Override
    public void addPost(PostVO postVO){
        sqlSession.insert("postMapper.addPost",postVO);
    }

}
