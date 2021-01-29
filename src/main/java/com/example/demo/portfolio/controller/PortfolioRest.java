package com.example.demo.portfolio.controller;

import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/restPortfolio/*")
public class PortfolioRest {

    @Autowired
    PortfolioService portfolioService;
    //
    @GetMapping("portList")
    public List<PortfolioVO> portList(HttpSession session){
        session.setAttribute("userId","user01");
        /*portfolioVO.setUserId((String)session.getAttribute("userId"));*/
        List<PortfolioVO> portfolioVOList = portfolioService.getPortList((String)session.getAttribute("userId"));
        return portfolioVOList; /*레스트는 데이터만 보내주니까*/
    }
}
