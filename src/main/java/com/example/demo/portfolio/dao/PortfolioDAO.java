package com.example.demo.portfolio.dao;

import com.example.demo.portfolio.vo.PortfolioVO;

import java.util.List;

public interface PortfolioDAO {

    //포트폴리오 등록
    public int addPort(PortfolioVO addPort);

    //내부 포트폴리오 등록
//    public int addInPort(PortfolioVO addInPort);

    //포트폴리오 수정
    public int updatePort(PortfolioVO updatePort);

    //포트폴리오 삭제
    public int deletePort(PortfolioVO deletePort);

    //포트폴리오 상세 조회
    public PortfolioVO getPort(int portNo);

    //포트폴리오 목록 조회
    public List<PortfolioVO> getPortList(String userId);
}