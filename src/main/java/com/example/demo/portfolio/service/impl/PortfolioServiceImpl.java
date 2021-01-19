package com.example.demo.portfolio.service.impl;

import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.dto.PortfolioDTO;
import com.example.demo.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("portfolioServiceImpl")
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    @Qualifier("portfolioDAOImpl")
    PortfolioDAO portfolioDAO;

    @Override
    public int addExPort(PortfolioDTO.AddExPortDTO addExPortDTO){
        return portfolioDAO.addExPort(addExPortDTO);
    }

    @Override
    public PortfolioDTO.GetExPortDTO getExPort(int portNo){
        return portfolioDAO.getExPort(portNo);
    }
}
