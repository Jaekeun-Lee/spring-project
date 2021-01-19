package com.example.demo.project.service.impl;

import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    @Test

    public void addProject() {

        ProjectVO projectVO = new ProjectVO();

        projectVO.setLeaderId("user06");
        projectVO.setProjectName("맴버에도 추가하기");
        projectVO.setProgressClassification(2);
        projectVO.setProjectCategory(1);
        projectVO.setPreStartDate(new Date());
        projectVO.setPrePeriod(200);
        projectVO.setMeetingMethod(1);
        projectVO.setMeetingLocation("경기도 수원시");
        projectVO.setApplicationDeadline(new Date());
        projectVO.setProjectDetail("project detail");
        projectVO.setApplicantQuestionA("applicantQuestionA");
        projectVO.setRecruitmentMemberCnt(3);

        projectService.addProject(projectVO);


    }

    //@Test
    public void getProject() {

        ProjectVO projectVO = new ProjectVO();

        projectVO = projectService.getProject(1);

        //테스트 데이터 프로젝트 명
        Assert.assertEquals("testProject", projectVO.getProjectName());
        //테스트 데이터 댓글 수
        Assert.assertEquals(3, projectVO.getProjectReply().get(0).getReplyNo());
        //테스트 데이터 지원자 수
        Assert.assertEquals(2, projectVO.getApplicantsCnt());
        //테스트 데이터 첫번째 해시태그
        Assert.assertEquals("test", projectVO.getSkillHashTag().get(0));
        //테스트 데이터 팀원
        Assert.assertEquals("user01", projectVO.getTeamMember().get(0).getUserId());
        Assert.assertEquals("DEFAULTImage.jpg", projectVO.getTeamMember().get(0).getProfileImg());
    }

    //@Test
    public void addProjectReply() {

        ProjectReplyDTO projectReplyDTO = new ProjectReplyDTO();
        projectReplyDTO.setProjectNo(1);
        projectReplyDTO.setReplyContent("addReplyTest");
        projectReplyDTO.setReplyUserId("user02");

        Assert.assertEquals(1, projectService.addProjectReply(projectReplyDTO));

    }


    //@Test
    public void getMyProject() {

        MyProjectVO myProjectVO = projectService.getMyProject(1);

        Assert.assertEquals(1, myProjectVO.getTodoList().get(0).getProjectNO());
        Assert.assertEquals(1, myProjectVO.getTodoList().get(0).getTodoNo());
        Assert.assertEquals("Todo Test1", myProjectVO.getTodoList().get(0).getTodoContent());
        Assert.assertEquals("user01", myProjectVO.getTodoList().get(0).getUserId());
        Assert.assertEquals(2, myProjectVO.getTodoList().get(0).getTodoStatus());
        Assert.assertEquals(2, myProjectVO.getTodoList().get(1).getTodoNo());
        Assert.assertEquals(3, myProjectVO.getTodoList().get(2).getTodoNo());

    }

    //@Test
    public void addTodo() {

        TodoVO todoVO = new TodoVO();
        todoVO.setProjectNO(1);
        todoVO.setUserId("user01");
        todoVO.setTodoContent("Todo Add Test");

        Assert.assertEquals(1,projectService.addTodo(todoVO));

    }
}