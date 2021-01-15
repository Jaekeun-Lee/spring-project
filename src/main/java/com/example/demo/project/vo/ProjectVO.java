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


}
