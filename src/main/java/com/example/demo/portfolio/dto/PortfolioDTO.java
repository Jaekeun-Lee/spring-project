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

    //외부 포트폴리오 상세 조회
    @Data
    public static class GetPortDTO {
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

    //외부 포트폴리오 삭제
    @Data
    public static class DeleteExPortDTO {
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
    
    //외부 포트폴리오 수정
    @Data
    public static class UpdateExPortDTO {
        private int portNo;
        private Date portProjectStartDate;
        private Date portProjectEndDate;
        private String portThumbnailImg;
        private String portDescription;
        private int portMemberCnt;
        private String portFileName;
        private List<String> portSkillTag;
        private String portTitle;
    }

    //내부 포트폴리오 작성
    @Data
    public static class AddInPortDTO{

    }
}
