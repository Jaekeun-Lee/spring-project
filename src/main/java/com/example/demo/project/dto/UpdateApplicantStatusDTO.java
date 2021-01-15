package com.example.demo.project.dto;

public class UpdateApplicantStatusDTO {
    private int applicantNo;
    private int applicantStatus;

    public UpdateApplicantStatusDTO() {
    }

    public int getApplicantNo() {
        return applicantNo;
    }

    public void setApplicantNo(int applicantNo) {
        this.applicantNo = applicantNo;
    }

    public int getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(int applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

}