package com.example.demo.common.vo;

public class FileVO {
    private int fileNo;
    private String uploadfileA;
    private String uploadfileB;
    private String uploadfileC;
    private String uploadfileD;
    private int postNo;
    private int projectNo;
    private int portfolioNo;

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getUploadfileA() {
        return uploadfileA;
    }

    public void setUploadfileA(String uploadfileA) {
        this.uploadfileA = uploadfileA;
    }

    public String getUploadfileB() {
        return uploadfileB;
    }

    public void setUploadfileB(String uploadfileB) {
        this.uploadfileB = uploadfileB;
    }

    public String getUploadfileC() {
        return uploadfileC;
    }

    public void setUploadfileC(String uploadfileC) {
        this.uploadfileC = uploadfileC;
    }

    public String getUploadfileD() {
        return uploadfileD;
    }

    public void setUploadfileD(String uploadfileD) {
        this.uploadfileD = uploadfileD;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getPortfolioNo() {
        return portfolioNo;
    }

    public void setPortfolioNo(int portfolioNo) {
        this.portfolioNo = portfolioNo;
    }

    @Override
    public String toString() {
        return "FileVO{" +
                "fileNo=" + fileNo +
                ", uploadfileA='" + uploadfileA + '\'' +
                ", uploadfileB='" + uploadfileB + '\'' +
                ", uploadfileC='" + uploadfileC + '\'' +
                ", uploadfileD='" + uploadfileD + '\'' +
                ", postNo=" + postNo +
                ", projectNo=" + projectNo +
                ", portfolioNo=" + portfolioNo +
                '}';
    }
}
