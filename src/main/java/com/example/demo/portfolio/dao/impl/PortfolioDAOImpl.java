package com.example.demo.portfolio.dao.impl;

import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.dto.PortfolioDTO;
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

    public int addExPort(PortfolioDTO.AddExPortDTO addExPortDTO){
        return sqlSession.insert("portfolioMapper.addExPort", addExPortDTO);
    }

    public PortfolioDTO.GetPortDTO getPort(int portNo){
        return sqlSession.selectOne("portfolioMapper.getPort", portNo);
    }

    public int deleteExPort(PortfolioDTO.DeleteExPortDTO deleteExPortDTO){
        return sqlSession.delete("portfolioMapper.deleteExPort", deleteExPortDTO);
    }

    public int updateExPort(PortfolioDTO.UpdateExPortDTO updateExPortDTO){
        return sqlSession.update("portfolioMapper.updateExPort", updateExPortDTO);
    }



}
