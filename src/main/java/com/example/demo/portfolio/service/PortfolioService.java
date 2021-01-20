package com.example.demo.portfolio.service;

import com.example.demo.portfolio.dto.PortfolioDTO;
import org.springframework.security.core.parameters.P;

import javax.sound.sampled.Port;

public interface PortfolioService {

    //외부 포트폴리오 등록
    public int addExPort(PortfolioDTO.AddExPortDTO addExPortDTO);

    //외부 포트폴리오 조회
    public PortfolioDTO.GetPortDTO getPort(int portNo);

    //외부 포트폴리오 삭제
    public int deleteExPort(PortfolioDTO.DeleteExPortDTO deleteExPortDTO);

    //외부 포트폴리오 수정
    public int updateExPort(PortfolioDTO.UpdateExPortDTO updateExPortDTO);

}
