package com.example.demo.community.vo;


import java.util.Date;

public class ReplyVO {

    private int replyNo;
    private int postNo;
    private int projectNo;
    private String replyUseId;
    private String replyContent;
    private String replyRegDate;
    private Date reg_date;

    public ReplyVO() {
    }

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
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

    public String getReplyUseId() {
        return replyUseId;
    }

    public void setReplyUseId(String replyUseId) {
        this.replyUseId = replyUseId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyRegDate() {
        return replyRegDate;
    }

    public void setReplyRegDate(String replyRegDate) {
        this.replyRegDate = replyRegDate;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "ReplyVO{" +
                "replyNo=" + replyNo +
                ", postNo=" + postNo +
                ", projectNo=" + projectNo +
                ", replyUseId='" + replyUseId + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyRegDate='" + replyRegDate + '\'' +
                ", reg_date=" + reg_date +
                '}';
    }
}



