package com.example.demo.portfolio.dao;

import com.example.demo.portfolio.dto.PortfolioDTO;

public interface PortfolioDAO {

    //외부 포트폴리오 등록
    public int addExPort(PortfolioDTO.AddExPortDTO addExPortDTO);

    //외부 포트폴리오 조회
    public PortfolioDTO.GetPortDTO getPort(int portNo);

    //외부 포트폴리오 삭제
    public int deleteExPort(PortfolioDTO.DeleteExPortDTO deleteExPortDTO);

    //외부 포트폴리오 수정
    public int updateExPort(PortfolioDTO.UpdateExPortDTO updateExPortDTO);
}
