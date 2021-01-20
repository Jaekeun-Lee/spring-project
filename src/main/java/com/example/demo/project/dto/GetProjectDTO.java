package com.example.demo.project.dto;

public class GetProjectDTO {
    private String userId;
    private int projectNo;

    public GetProjectDTO() {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GetProjectDTO{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", projectNo=").append(projectNo);
        sb.append('}');
        return sb.toString();
    }
}
