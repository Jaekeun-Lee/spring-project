package com.example.demo.portfolio.service.impl;

import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("portfolioServiceImpl")
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    @Qualifier("portfolioDAOImpl")
    PortfolioDAO portfolioDAO;

    @Override
    public int addExPort(PortfolioVO addExPort){
        return portfolioDAO.addExPort(addExPort);
    }

    @Override
    public PortfolioVO getPort(int portNo){
        return portfolioDAO.getPort(portNo);
    }

    @Override
    public int deleteExPort(PortfolioVO deleteExPort){
        return portfolioDAO.deleteExPort(deleteExPort);
    }

    @Override
    public int updateExPort(PortfolioVO updateExPort){
        return portfolioDAO.updateExPort(updateExPort);
    }
}

