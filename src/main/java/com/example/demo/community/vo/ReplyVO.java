package com.example.demo.community.vo;

import java.util.Date;

public class ReplyVO {
    private int replyNo;
    private int postNo;
    private int projectNo;
    private String replyUserId;
    private String replyContent;
    private Date replyRegDate;

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

    public Date getReplyRegDate() {
        return replyRegDate;
    }

    public void setReplyRegDate(Date replyRegDate) {
        this.replyRegDate = replyRegDate;
    }
}
