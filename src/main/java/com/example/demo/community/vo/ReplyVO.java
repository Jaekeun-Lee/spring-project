package com.example.demo.community.vo;


import java.util.Date;

public class ReplyVO {

    private int replyNo;
    private int postNo;
    private int projectNo;
    private String replyUserId;
    private String replyContent;
    private Date regDate;

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

    public String getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReg_date() {
        return regDate;
    }

    public void setReg_date(Date reg_date) {
        this.regDate = reg_date;
    }

    @Override
    public String toString() {
        return "ReplyVO{" +
                "replyNo=" + replyNo +
                ", postNo=" + postNo +
                ", projectNo=" + projectNo +
                ", replyUseId='" + replyUserId + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", reg_date=" + regDate +
                '}';
    }
}



