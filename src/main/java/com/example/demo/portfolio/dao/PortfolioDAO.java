package com.example.demo.portfolio.dao;

import com.example.demo.portfolio.vo.PortfolioVO;

public interface PortfolioDAO {

    //외부 포트폴리오 등록
    public int addExPort(PortfolioVO addExPort);

    //외부 포트폴리오 조회
    public PortfolioVO getPort(int portNo);

    //외부 포트폴리오 삭제
    public int deleteExPort(PortfolioVO deleteExPort);

    //외부 포트폴리오 수정
    public int updateExPort(PortfolioVO updateExPort);
}
