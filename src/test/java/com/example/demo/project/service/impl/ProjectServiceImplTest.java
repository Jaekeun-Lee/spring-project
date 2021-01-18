package com.example.demo.project.service.impl;

import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    //@Test
    public void addProject() {

        ProjectVO projectVO = new ProjectVO();

        projectVO.setLeaderId("user01");
        projectVO.setProjectName("ADD PROJECT TEST");
        projectVO.setProgressClassification(2);
        projectVO.setProjectCategory(1);
        projectVO.setPreStartDate(new Date(2021-01-11));
        projectVO.setPrePeriod(200);
        projectVO.setMeetingMethod(1);
        projectVO.setMeetingLocation("경기도 이천시");
        projectVO.setApplicationDeadline(new Date(2021-01-30));
        projectVO.setProjectDetail("add project test detail");
        projectVO.setApplicantQuestionA("applicantQuestionA");
        projectVO.setApplicantQuestionB("applicantQuestionB");
        projectVO.setRecruitmentMemberCnt(5);

        Assert.assertEquals(1,projectService.addProject(projectVO));

    }

    @Test
    public void getProject() {

        ProjectVO projectVO = new ProjectVO();

        projectVO = projectService.getProject(1);
        System.out.println("@@@@@@@@@@"+projectVO);

        Assert.assertEquals("testProject", projectVO.getProjectName());
        Assert.assertEquals(3, projectVO.getProjectReply().get(0).getReplyNo());
        Assert.assertEquals(2, projectVO.getProjectReply().size());
        Assert.assertEquals(2, projectVO.getApplicantsCnt());
    }

    @Test
    public void addProjectReply(){

        ProjectReplyDTO projectReplyDTO = new ProjectReplyDTO();
        projectReplyDTO.setProjectNo(1);
        projectReplyDTO.setReplyContent("addReplyTest");
        projectReplyDTO.setReplyUserId("user02");

        Assert.assertEquals(1,projectService.addProjectReply(projectReplyDTO));

    }
}