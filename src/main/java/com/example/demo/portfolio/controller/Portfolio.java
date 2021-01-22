package com.example.demo.portfolio.controller;

import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/port/*")
public class Portfolio {

    @Autowired
    private PortfolioService portfolioService;

    //포트폴리오 등록
    @GetMapping("addPort")
    public String addPortView(){

        return "portfolio/addPortfolio";
    }

    //포트폴리오 등록
    @PostMapping("addPort")
    public String addPort(@ModelAttribute PortfolioVO portfolioVO){
        System.out.println("포트폴리오연결합니다"+portfolioVO);
        portfolioService.addPort(portfolioVO);
        return "portfolio/getPortfolio";

    }

    //포트폴리오 상세조회
    @GetMapping("getPort")
    public String getPort(@RequestParam("portNo") int portNo, Model model){ //"portNo" = key, int portNo = value
        PortfolioVO portfolioVO = portfolioService.getPort(portNo); //value로 디비에서 정보를 가져옴

        model.addAttribute("portfolio",portfolioVO);    //정보(=디비에서 가져옴)를 주머니에 담음
        return "portfolio/getPortfolio"; //정보가 출발했다.
    }


    //모델어트리뷰트는 오브젝트 스코프야. session, request, application
    //모델이 해주는 건 request
    //request에 담아서 가져가는 것

}
