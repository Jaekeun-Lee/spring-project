package com.example.demo.portfolio.controller;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("port/*")
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
    public String addPort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session){
        portfolioVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
        portfolioService.addPort(portfolioVO);
        return "redirect:/port/portList";

    }

    //포트폴리오 수정
    @GetMapping("updatePort")
    public String updatePortView(@RequestParam("portNo") int param, Model model){
        PortfolioVO portfolioVO = portfolioService.getPort(param);
        model.addAttribute("portfolio",portfolioVO);
        return "portfolio/updatePortfolio";
    }

    @PostMapping("updatePort")
    public String updatePort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session, Model model){
        portfolioVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
        portfolioService.updatePort(portfolioVO);
        model.addAttribute("portfolio",portfolioService.getPort(portfolioVO.getPortNo()));
        return "portfolio/getPortfolio";
    }

    //포트폴리오 삭제
    @GetMapping("deletePort")
    public String deletePort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session){
        portfolioVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
        portfolioService.deletePort(portfolioVO);
        return "redirect:/port/portList";
    }

    //포트폴리오 상세조회
    @GetMapping("getPort")
    public String getPort(@RequestParam("portNo") int portNo, Model model){
        PortfolioVO portfolioVO = portfolioService.getPort(portNo);
        model.addAttribute("portfolio",portfolioVO);
        return "portfolio/getPortfolio";
    }

    //포트폴리오 목록조회
    @GetMapping("portList")
    public String getPortList(HttpSession session, Model model){
        List<PortfolioVO> portfolioVOList = portfolioService.getPortList(((MemberVO)session.getAttribute("user")).getUserId());
       model.addAttribute("portfolio", portfolioVOList);
       return "portfolio/getPortfolioList";

    }
}
