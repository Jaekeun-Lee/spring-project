package com.example.demo.project.vo;

import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.vo.MemberVO;

import java.util.Date;
import java.util.List;

public class ProjectVO {

    private int projectNo;
    private String leaderId;
    private List<MemberVO> teamMember;
    private String projectName;
    private int progressClassification;
    private int projectCategory;
    private Date preStartDate;
    private Date startDate;
    private int prePeriod;
    private Date regDate;
    private Date applicationDeadline;
    private int meetingMethod;
    private String meetingLocation;
    private List<String> skillHashTag;
    private String applicantQuestionA;
    private String applicantQuestionB;
    private String applicantQuestionC;
    private List<ReplyVO> projectReply;
    private int applicantsCnt;
    private int recruitmentMemberCnt;
    private int projectViewCnt;
    private int projectStatus;
    private int endProjectCnt;

    public ProjectVO() {
    }

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public List<MemberVO> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(List<MemberVO> teamMember) {
		this.teamMember = teamMember;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProgressClassification() {
		return progressClassification;
	}

	public void setProgressClassification(int progressClassification) {
		this.progressClassification = progressClassification;
	}

	public int getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(int projectCategory) {
		this.projectCategory = projectCategory;
	}

	public Date getPreStartDate() {
		return preStartDate;
	}

	public void setPreStartDate(Date preStartDate) {
		this.preStartDate = preStartDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getPrePeriod() {
		return prePeriod;
	}

	public void setPrePeriod(int prePeriod) {
		this.prePeriod = prePeriod;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public int getMeetingMethod() {
		return meetingMethod;
	}

	public void setMeetingMethod(int meetingMethod) {
		this.meetingMethod = meetingMethod;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}

	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}

	public List<String> getSkillHashTag() {
		return skillHashTag;
	}

	public void setSkillHashTag(List<String> skillHashTag) {
		this.skillHashTag = skillHashTag;
	}

	public String getApplicantQuestionA() {
		return applicantQuestionA;
	}

	public void setApplicantQuestionA(String applicantQuestionA) {
		this.applicantQuestionA = applicantQuestionA;
	}

	public String getApplicantQuestionB() {
		return applicantQuestionB;
	}

	public void setApplicantQuestionB(String applicantQuestionB) {
		this.applicantQuestionB = applicantQuestionB;
	}

	public String getApplicantQuestionC() {
		return applicantQuestionC;
	}

	public void setApplicantQuestionC(String applicantQuestionC) {
		this.applicantQuestionC = applicantQuestionC;
	}

	public List<ReplyVO> getProjectReply() {
		return projectReply;
	}

	public void setProjectReply(List<ReplyVO> projectReply) {
		this.projectReply = projectReply;
	}

	public int getApplicantsCnt() {
		return applicantsCnt;
	}

	public void setApplicantsCnt(int applicantsCnt) {
		this.applicantsCnt = applicantsCnt;
	}

	public int getRecruitmentMemberCnt() {
		return recruitmentMemberCnt;
	}

	public void setRecruitmentMemberCnt(int recruitmentMemberCnt) {
		this.recruitmentMemberCnt = recruitmentMemberCnt;
	}

	public int getProjectViewCnt() {
		return projectViewCnt;
	}

	public void setProjectViewCnt(int projectViewCnt) {
		this.projectViewCnt = projectViewCnt;
	}

	public int getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getEndProjectCnt() {
		return endProjectCnt;
	}

	public void setEndProjectCnt(int endProjectCnt) {
		this.endProjectCnt = endProjectCnt;
	}

	@Override
	public String toString() {
		return "ProjectVO [projectNo=" + projectNo + ", leaderId=" + leaderId + ", teamMember=" + teamMember
				+ ", projectName=" + projectName + ", progressClassification=" + progressClassification
				+ ", projectCategory=" + projectCategory + ", preStartDate=" + preStartDate + ", startDate=" + startDate
				+ ", prePeriod=" + prePeriod + ", regDate=" + regDate + ", applicationDeadline=" + applicationDeadline
				+ ", meetingMethod=" + meetingMethod + ", meetingLocation=" + meetingLocation + ", skillHashTag="
				+ skillHashTag + ", applicantQuestionA=" + applicantQuestionA + ", applicantQuestionB="
				+ applicantQuestionB + ", applicantQuestionC=" + applicantQuestionC + ", projectReply=" + projectReply
				+ ", applicantsCnt=" + applicantsCnt + ", recruitmentMemberCnt=" + recruitmentMemberCnt
				+ ", projectViewCnt=" + projectViewCnt + ", projectStatus=" + projectStatus + ", endProjectCnt="
				+ endProjectCnt + "]";
	}
    
    


}
