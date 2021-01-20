package com.example.demo.project.service.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dto.GetProjectDTO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    //@Test
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

        GetProjectDTO getProjectDTO = new GetProjectDTO();
        getProjectDTO.setProjectNo(1);
        getProjectDTO.setUserId("user01");
        ProjectVO projectVO = projectService.getProject(getProjectDTO);

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
        //테스트 데이터 북마크여부
        Assert.assertEquals(1, projectVO.getBookmarkCheck());

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

        Assert.assertEquals(1, projectService.addTodo(todoVO));

    }

    //@Test
    public void addBookmark() {

        ProjectBookmarkDTO projectBookmarkDTO = new ProjectBookmarkDTO();
        projectBookmarkDTO.setProjectNo(2);
        projectBookmarkDTO.setUserId("user06");

        Assert.assertEquals(1, projectService.addBookmark(projectBookmarkDTO));

    }

    //@Test
    public void deleteBookmark() {

        ProjectBookmarkDTO projectBookmarkDTO = new ProjectBookmarkDTO();
        projectBookmarkDTO.setBookmarkNo(10);

        Assert.assertEquals(1,projectService.deleteBookmark(projectBookmarkDTO));

    }

    @Test
    public void getProjectList() {

        SearchVO searchVO = new SearchVO();

        searchVO.setCurrentPage(1);
        searchVO.setPageSize(10);

        //searchConditionA 프로젝트 카테고리 = 1:개발, 2:기획, 3:디자인
        //searchVO.setSearchConditionA(1);

        //searchConditionB 미팅방식 = 1:대면, 2:비대면
        //searchVO.setSearchConditionB(1);

        //searchConditionC 검색어 조건 = 1:제목, 2:해시태그, 3:프로젝트 내용
        //searchVO.setSearchConditionC(1);

        //searchConditionD 프로젝트 상태 조건 = 1:모집중, 2:모집완료, 3:종료
        searchVO.setSearchConditionD(3);


        //searchVO.setSearchKeyword("test");

        //sort 정렬조건 = 1: 최신등록순, 2:모집 마감 임박 순
        searchVO.setSort(1);


        List<ProjectVO> projectVOList = projectService.getProjectList(searchVO);
        Assert.assertEquals(1,projectVOList.size());


        //목록에서 북마크 추가 표시 확인
        //searchVO.setUserId("user01");


    }

    /*
    @Test
    public void getAppliedProjectList() {

        SearchVO searchVO = new SearchVO();

        searchVO.setCurrentPage(1);
        searchVO.setPageSize(6);
        searchVO.setUserId("user03");
        searchVO.setSearchConditionB(1);

        Map<String, Object> map = projectService.getAppliedProjectList(searchVO);

        List<Object> list1 = (List<Object>)map.get("list1");
        List<Object> list2 = (List<Object>)map.get("list2");
        Assert.assertEquals(2, list1.size());
        Assert.assertEquals(2, list2.size());

        Integer totalCount = (Integer)map.get("totalCount");
    }
    */
}