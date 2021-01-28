package com.example.demo.portfolio.controller;

import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String addPort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session, Model model){
        System.out.println("포트폴리오추가합니다"+portfolioVO);
        session.setAttribute("userId","user01"); //session이 있으면 통째로 지우면 됨. 왜냐면 session에 알아서 들어감.
        portfolioVO.setUserId((String)session.getAttribute("userId"));
        portfolioService.addPort(portfolioVO);
        model.addAttribute("portfolio",portfolioVO);
        return "portfolio/getPortfolio";

    }

    @GetMapping("updatePort")
    public String updatePortView(@RequestParam("portNo") int param, Model model){
        PortfolioVO portfolioVO = portfolioService.getPort(param);
        model.addAttribute("portfolio",portfolioVO);
        return "portfolio/updatePortfolio";
    }

    @PostMapping("updatePort")
    public String updatePort(@ModelAttribute PortfolioVO portfolioVO, HttpSession session, Model model){
        System.out.println("포트폴리오수정합니다."+portfolioVO);
        session.setAttribute("userId","user01");
        portfolioVO.setUserId((String)session.getAttribute("userId"));  //사용자가 수정한 내용을 DB에 보내는 것
        portfolioService.updatePort(portfolioVO);
        model.addAttribute("portfolio",portfolioVO);
        return "portfolio/getPortfolio";

    }

    //포트폴리오 상세조회
    @GetMapping("getPort")
    public String getPort(@RequestParam("portNo") int portNo, Model model){ //"portNo" = key, int portNo = value
        PortfolioVO portfolioVO = portfolioService.getPort(portNo); //value로 디비에서 정보를 가져옴

        model.addAttribute("portfolio",portfolioVO);    //정보(=디비에서 가져옴)를 주머니에 담음
        return "portfolio/getPortfolio"; //정보가 출발했다.
    }

    //포트폴리오 목록조회
    @GetMapping("portList")
    public String getPortList(HttpSession session, Model model){
        session.setAttribute("userId","user02");
        /*portfolioVO.setUserId((String)session.getAttribute("userId"));*/
        List<PortfolioVO> portfolioVOList = portfolioService.getPortList((String)session.getAttribute("userId"));
       model.addAttribute("portfolio", portfolioVOList);
       return "portfolio/getPortfolioList";

    }




    //모델어트리뷰트는 오브젝트 스코프야. session, request, application
    //모델이 해주는 건 request
    //request에 담아서 가져가는 것

}
