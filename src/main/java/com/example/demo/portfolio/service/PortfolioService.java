package com.example.demo.portfolio.service;

import com.example.demo.portfolio.vo.PortfolioVO;
import org.springframework.security.core.parameters.P;

import javax.sound.sampled.Port;

public interface PortfolioService {

    //외부 포트폴리오 등록
    public int addExPort(PortfolioVO addExPort);

    //외부 포트폴리오 조회
    public PortfolioVO getPort(int portNo);

    //외부 포트폴리오 삭제
    public int deleteExPort(PortfolioVO deleteExPort);

    //외부 포트폴리오 수정
    public int updateExPort(PortfolioVO updateExPortDTO);

}
