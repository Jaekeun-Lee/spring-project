package com.example.demo.portfolio.vo;

import java.util.Date;
import java.util.List;

public class PortfolioVO {
    private int portNo;
    private String userId;
    private int projectNo;
    private Date portProjectStartDate;  //포트포리오에 등록할 프로젝트 시작 날짜
    private Date portProjectEndDate;    //포트포리오에 등록할 프로젝트 종료 날짜
    private String portDescription;     //설명글
    private String portTitle;           //포트폴리오 제목
    private int portMemberCnt;          //프로젝트 참가 총 인원 수
    private String portThumbnailImg;    //대표 이미지
    private String portFileName;        //첨부파일
    private List<String> portSkillTag;

    public PortfolioVO() {
    }

    public int getPortNo() {
        return portNo;
    }

    public void setPortNo(int portNo) {
        this.portNo = portNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public Date getPortProjectStartDate() {
        return portProjectStartDate;
    }

    public void setPortProjectStartDate(Date portProjectStartDate) {
        this.portProjectStartDate = portProjectStartDate;
    }

    public Date getPortProjectEndDate() {
        return portProjectEndDate;
    }

    public void setPortProjectEndDate(Date portProjectEndDate) {
        this.portProjectEndDate = portProjectEndDate;
    }

    public String getPortDescription() {
        return portDescription;
    }

    public void setPortDescription(String portDescription) {
        this.portDescription = portDescription;
    }

    public String getPortTitle() {
        return portTitle;
    }

    public void setPortTitle(String portTitle) {
        this.portTitle = portTitle;
    }

    public int getPortMemberCnt() {
        return portMemberCnt;
    }

    public void setPortMemberCnt(int portMemberCnt) {
        this.portMemberCnt = portMemberCnt;
    }

    public String getPortThumbnailImg() {
        return portThumbnailImg;
    }

    public void setPortThumbnailImg(String portThumbnailImg) {
        this.portThumbnailImg = portThumbnailImg;
    }

    public String getPortFileName() {
        return portFileName;
    }

    public void setPortFileName(String portFileName) {
        this.portFileName = portFileName;
    }

    public List<String> getPortSkillTag() {
        return portSkillTag;
    }

    public void setPortSkillTag(List<String> portSkillTag) {
        this.portSkillTag = portSkillTag;
    }


}



