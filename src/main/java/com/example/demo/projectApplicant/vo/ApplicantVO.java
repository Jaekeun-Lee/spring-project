package com.example.demo.projectApplicant.vo;

import java.util.List;

public class ApplicantVO {
	
	private int applicantNo;
	private int projectNo;
	private String userId;
	private String profileImg;
	private int applicantStatus;
	private String applicantAnswerA;
	private String applicantAnswerB;
	private String applicantAnswerC;
	private String introToMember;

	public ApplicantVO() {
	}

	public int getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(int applicantNo) {
		this.applicantNo = applicantNo;
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

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(int applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	public String getApplicantAnswerA() {
		return applicantAnswerA;
	}

	public void setApplicantAnswerA(String applicantAnswerA) {
		this.applicantAnswerA = applicantAnswerA;
	}

	public String getApplicantAnswerB() {
		return applicantAnswerB;
	}

	public void setApplicantAnswerB(String applicantAnswerB) {
		this.applicantAnswerB = applicantAnswerB;
	}

	public String getApplicantAnswerC() {
		return applicantAnswerC;
	}

	public void setApplicantAnswerC(String applicantAnswerC) {
		this.applicantAnswerC = applicantAnswerC;
	}

	public String getIntroToMember() {
		return introToMember;
	}

	public void setIntroToMember(String introToMember) {
		this.introToMember = introToMember;
	}

	@Override
	public String toString() {
		return "ApplicantVO [applicantNo=" + applicantNo + ", projectNo=" + projectNo + ", userId=" + userId
				+ ", profileImg=" + profileImg + ", applicantStatus=" + applicantStatus + ", applicantAnswerA="
				+ applicantAnswerA + ", applicantAnswerB=" + applicantAnswerB + ", applicantAnswerC=" + applicantAnswerC
				+ ", introToMember=" + introToMember + "]";
	}

	
}
