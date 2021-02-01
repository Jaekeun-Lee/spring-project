package com.example.demo.common.vo;

public class ReviewVO {

    private int reviewNo;
    private int projectNo;
    private String projectName;
    private int reviewGrade;
    private String reviewComment;
    private String userId;

    public ReviewVO() {
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(int reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReviewVO{" +
                "reviewNo=" + reviewNo +
                ", projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", reviewGrade=" + reviewGrade +
                ", reviewComment='" + reviewComment + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
