package com.example.demo.portfolio.dao.impl;

import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Port;

@Repository("portfolioDAOImpl")
public class PortfolioDAOImpl implements PortfolioDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    public int addExPort(PortfolioVO addExPort){
        return sqlSession.insert("portfolioMapper.addExPort", addExPort);
    }

    public PortfolioVO getPort(int portNo){
        return sqlSession.selectOne("portfolioMapper.getPort", portNo);
    }

    public int deleteExPort(PortfolioVO deleteExPort){
        return sqlSession.delete("portfolioMapper.deleteExPort", deleteExPort);
    }

    public int updateExPort(PortfolioVO updateExPort){
        return sqlSession.update("portfolioMapper.updateExPort", updateExPort);
    }



}
