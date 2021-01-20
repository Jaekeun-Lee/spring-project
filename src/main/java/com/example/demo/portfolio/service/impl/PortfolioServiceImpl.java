package com.example.demo.portfolio.service.impl;

import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("portfolioServiceImpl")
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    @Qualifier("portfolioDAOImpl")
    PortfolioDAO portfolioDAO;

    @Override
    public int addPort(PortfolioVO addPort){
        return portfolioDAO.addPort(addPort);
    }

//    @Override
//    public int addInPort(PortfolioVO addInPort){
//        return portfolioDAO.addInPort(addInPort);
//    }

    @Override
    public int updatePort(PortfolioVO updatePort){
        return portfolioDAO.updatePort(updatePort);
    }

    @Override
    public int deletePort(PortfolioVO deletePort){
        return portfolioDAO.deletePort(deletePort);
    }

    @Override
    public PortfolioVO getPort(int portNo){
        return portfolioDAO.getPort(portNo);
    }

    @Override
    public List<PortfolioVO> getPortList(String userId) {
        return portfolioDAO.getPortList(userId);
    }
}

