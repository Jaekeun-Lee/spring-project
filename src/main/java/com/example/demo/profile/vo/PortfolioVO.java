package com.example.demo.profile.vo;

import java.util.Date;
import java.util.List;

public class PortfolioVO {
    private int portNo;
    private String portThumbnailImg; //대표 이미지
    private String portDescription; //설명글
    private Date portProjectStartDate;
    private Date portProjectEndDate;
    private int portMemberCnt;
    private String portFileName; //첨부파일
    private List<String> portSkillTag;
}
