package com.example.demo.portfolio.service.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.portfolio.dao.PortfolioDAO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int deletePort(Long portNo){
        return portfolioDAO.deletePort(portNo);
    }

    @Override
    public PortfolioVO getPort(Long portNo){
        return portfolioDAO.getPort(portNo);
    }

    @Override
    public Map<String,Object> getPortList(SearchVO searchVO){
        List<PortfolioVO> list = portfolioDAO.getPortList(searchVO);
        int totalCount = portfolioDAO.getTotalCount(searchVO);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list",list);
        map.put("totalCount", new Integer(totalCount));
        return map;

    }
//    public List<PortfolioVO> getPortList(PortfolioVO portfolioVO) {
//        return portfolioDAO.getPortList(portfolioVO);
//    }
}

