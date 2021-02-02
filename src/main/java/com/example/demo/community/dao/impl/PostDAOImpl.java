package com.example.demo.community.dao.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.dao.PostDAO;
import com.example.demo.community.vo.PostVO;
import com.example.demo.community.vo.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public int addReply(int replyNo){

        return sqlSession.insert("postMapper.addReply", replyNo);
    }

    @Override
    public PostVO getPost(int postNo){

        return sqlSession.selectOne("postMapper.getPost", postNo);
    }

    @Override
    public ReplyVO getReply(String replyUserId){

        return sqlSession.selectOne("postMapper.getReply", replyUserId);
    }

    @Override
    public void updatePost(PostVO postVO){

        sqlSession.update("postMapper.updatePost",postVO);
    }

    @Override
    public void updateReply(ReplyVO replyVO){

        sqlSession.update("postMapper.updateReply",replyVO);
    }

    @Override
    public void deletePost(PostVO postVO){

        sqlSession.delete("postMapper.deletePost",postVO);
    }

    @Override
    public void deleteReply(ReplyVO replyVO){

        sqlSession.delete("postMapper.deleteReply", replyVO);
    }

    @Override
    public List<PostVO> getPostList(SearchVO searchVO){
        return sqlSession.selectList("postMapper.getPostList", searchVO);
    }
//    @Override
//    public List<PostVO> getPostList(PostVO postVO){
//        return sqlSession.selectList("postMapper.getPostList",postVO);
//    }





    @Override
    public int getTotalCount(SearchVO searchVO){


        return sqlSession.selectOne("postMapper.getTotalCount", searchVO);
    }

//    @Override
//    public int plusViewCnt(int seq){
//
//        return  sqlSession.update("postMapper.plusViewCnt", seq);
//    }
}
