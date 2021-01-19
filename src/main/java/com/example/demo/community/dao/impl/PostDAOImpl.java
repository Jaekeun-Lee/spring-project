package com.example.demo.community.dao.impl;

import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.vo.PostVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("postDAOImpl")
public class PostDAOImpl implements PostDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        System.out.println("PostDatImpl::"+getClass()+".setSqlSession() Call:::");
        System.out.println("TEST APP DAO::");
        this.sqlSession = sqlSession;
    }

    public PostDAOImpl() {
        System.out.println("PostDaoImpl::"+getClass()+".default Constructor call:::");
    }

    @Override
    public void addPost(PostVO postVO){

        sqlSession.insert("postMapper.addPost",postVO);
    }

    @Override
    public PostVO getPost(int postNo){

        return sqlSession.selectOne("postMapper.getPost", postNo);
    }

    @Override
    public void updatePost(PostVO postVO){

        sqlSession.update("postMapper.updatePost",postVO);
    }

//    @Override
//    public void deletePost(PostVO postVO){
//
//        sqlSession.delete("postMapper.deletePost",postVO);
//    }
}
