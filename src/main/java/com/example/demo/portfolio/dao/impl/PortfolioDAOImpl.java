package com.example.demo.portfolio.dao.impl;

import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Port;
import java.util.List;

@Repository("portfolioDAOImpl")
public class PortfolioDAOImpl implements PortfolioDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    @Override
    public int addPort(PortfolioVO addPort){
        return sqlSession.insert("portfolioMapper.addPort", addPort);
    }

//    public int addInPort(PortfolioVO addInPort){
//        return sqlSession.insert("portfolioMapper.addInPort", addInPort);
//    }

    @Override
    public int updatePort(PortfolioVO updatePort){
        return sqlSession.update("portfolioMapper.updatePort", updatePort);
    }

    @Override
    public int deletePort(PortfolioVO deletePort){
        return sqlSession.delete("portfolioMapper.deletePort", deletePort);
    }

    @Override
    public PortfolioVO getPort(int portNo){
        return sqlSession.selectOne("portfolioMapper.getPort", portNo);
    }

    @Override
    public List<PortfolioVO> getPortList(String userId) {
        return sqlSession.selectList("portfolioMapper.getPortList",userId);
    }
}
