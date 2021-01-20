package com.example.demo.project.dto;


public class ProjectBookmarkDTO {
    private int bookmarkNo;
    private int projectNo;
    private String userId;

    public ProjectBookmarkDTO() {
    }

    public int getBookmarkNo() {
        return bookmarkNo;
    }

    public void setBookmarkNo(int bookmarkNo) {
        this.bookmarkNo = bookmarkNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProjectBookmarkDTO{");
        sb.append("bookmarkNo=").append(bookmarkNo);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
