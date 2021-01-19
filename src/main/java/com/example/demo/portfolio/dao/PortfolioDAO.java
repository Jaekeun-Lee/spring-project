package com.example.demo.portfolio.dao;

import com.example.demo.portfolio.dto.PortfolioDTO;

public interface PortfolioDAO {

    //외부 포트폴리오 등록
    public int addExPort(PortfolioDTO.AddExPortDTO addExPortDTO);

    //외부 포트폴리오 조회
    public PortfolioDTO.GetExPortDTO getExPort(int portNo);
}
