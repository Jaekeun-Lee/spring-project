package com.example.demo.community.vo;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ReplyVO {

    private int replyNo;
    private int postNo;
    private int projectNo;
    private String replyUserId;
    private String replyContent;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date regDate;

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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReplyVO{");
        sb.append("replyNo=").append(replyNo);
        sb.append(", postNo=").append(postNo);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", replyUserId='").append(replyUserId).append('\'');
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append('}');
        return sb.toString();
    }
}



