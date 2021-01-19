package com.example.demo.portfolio.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

public class PortfolioDTO {

    //외부 포트폴리오 등록
    @Data
    public static class AddExPortDTO {
        private int portNo;
        private String userId;
        private int projectNo;
        private Date portProjectStartDate;
        private Date portProjectEndDate;
        private String portThumbnailImg;
        private String portDescription;
        private int portMemberCnt;
        private String portFileName;
        private List<String> portSkillTag;
        private String portTitle;
    }

    //외부 포트폴리오 조회
    @Data
    public static class GetExPortDTO {
        private int portNo;
        private String userId;
        private int projectNo;
        private Date portProjectStartDate;
        private Date portProjectEndDate;
        private String portThumbnailImg;
        private String portDescription;
        private int portMemberCnt;
        private String portFileName;
        private List<String> portSkillTag;
        private String portTitle;
    }
}
