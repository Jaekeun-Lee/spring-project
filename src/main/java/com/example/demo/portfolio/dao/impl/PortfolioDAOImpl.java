package com.example.demo.portfolio.dao.impl;

import com.example.demo.common.vo.SearchVO;
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
    public int deletePort(Long portNo){
        return sqlSession.delete("portfolioMapper.deletePort", portNo);
    }

    @Override
    public PortfolioVO getPort(Long portNo){
        return sqlSession.selectOne("portfolioMapper.getPort", portNo);
    }

    @Override
    public List<PortfolioVO> getPortList(SearchVO searchVO){
        return sqlSession.selectList("portfolioMapper.getPortList",searchVO);
    }
//    public List<PortfolioVO> getPortList(PortfolioVO portfolioVO) {
//        return sqlSession.selectList("portfolioMapper.getPortList",portfolioVO);
//    }

    @Override
    public int getTotalCount(SearchVO searchVO){
        return sqlSession.selectOne("portfolioMapper.getTotalCount",searchVO);
    }
}
