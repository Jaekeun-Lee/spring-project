package com.example.demo.projectApplicant.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicantDAOTest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicantDAOTest() {
	}
	
	//@Test
//	public void getProject(){
//		
//		ProjectVO projectVO = new ProjectVO();
//		
//		projectVO = projectApplicantService.getProject(3);
//		System.out.println(projectVO);
//		
//		Assert.assertEquals("user02", projectVO.getLeaderId());
//
//	}
	
	//@Test
//	public void addProject() {
		
		//Change the project number to sequence... : hyein
		//Check userVO projectNO : hyein
//		ProjectVO projectVO = new ProjectVO();
//		Date deadLine = new Date(2021-01-10);
//		Date preStartDate = new Date(2021-01-11);
//		Date today = new Date();
//		
//		
//		projectVO.setApplicantQuestionA("test질문A");
//		projectVO.setApplicantQuestionB("test질문B");
//		projectVO.setApplicantQuestionC("test질문C");
//		projectVO.setApplicationDeadline(deadLine);
//		projectVO.setLeaderId("user02");
//		projectVO.setMeetingLocation("서울시 중랑구");
//		projectVO.setMeetingMethod(2);
//		projectVO.setPrePeriod(3);
//		projectVO.setPreStartDate(preStartDate);
//		projectVO.setProgressClassification(2);
//		projectVO.setProjectCategory(1);
//		projectVO.setProjectName("기존 유지 보수 프로젝트");
//		projectVO.setProjectNo(3);
//		projectVO.setRegDate(today);
//		projectVO.setRecruitmentMemberCnt(4);
//		projectVO.setProjectDetail("test 상세 정보");
//		
//		projectApplicantService.addProject(projectVO);
//		
//		projectVO = projectApplicantService.getProject(3);
//		
//		Assert.assertEquals("user02", projectVO.getLeaderId());
//	}
	
	//@Test
	public void getApplicant() {
		
		ApplicantVO applicantVO = new ApplicantVO();
		
		applicantVO = projectApplicantService.getApplicant(1);
		
		System.out.println(applicantVO);
		
		Assert.assertEquals("없습니다", applicantVO.getApplicantAnswerA());
	}
	
	//@Test
	public void addApplicant() {
		
		ApplicantVO applicantVO = new ApplicantVO();
		ProjectVO projectVO = new ProjectVO();
		projectVO.setProjectNo(2);
		
		applicantVO.setApplicantAnswerA("답변입니다2");
		applicantVO.setApplicantNo(4);
		applicantVO.setIntroToMember("잘하겠습니다2");
		applicantVO.setProjectVO(projectVO);
		applicantVO.setUserId("user03");
		
		System.out.println(applicantVO);
		
		projectApplicantService.addApplicant(applicantVO);
		
		applicantVO = projectApplicantService.getApplicant(1);
		System.out.println(applicantVO);
		
		Assert.assertEquals("user05", applicantVO.getUserId());
	}
	
	//@Test
	public void getApplicantList() {
		
		SearchVO searchVO = new SearchVO();
		
		searchVO.setCurrentPage(1);
		searchVO.setPageSize(6);
		
		Map<String, Object> map = projectApplicantService.getApplicantList(searchVO);
		
		List<Object> list = (List<Object>)map.get("list");
		System.out.println(list);
		Assert.assertEquals(2,  list.size());
		
		Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	}
	
	//@Test
	public void getAppliedProjectList() {
		
		SearchVO searchVO = new SearchVO();
		
		searchVO.setCurrentPage(1);
		searchVO.setPageSize(6);
		searchVO.setUserId("user03");
		searchVO.setSearchConditionA(2);
		
		Map<String, Object> map = projectApplicantService.getAppliedProjectList(searchVO);
		
		List<Object> list = (List<Object>)map.get("list1");

		Assert.assertEquals(2, list.size());
		
		Integer totalCount = (Integer)map.get("totalCount");
	}
	
	@Test
	public void updateApplicantStatus() {
		
		UpdateApplicantStatusDTO updateApplicantStatusDTO = new UpdateApplicantStatusDTO();
		updateApplicantStatusDTO.setApplicantNo(2);
		updateApplicantStatusDTO.setApplicantStatus(5);
		updateApplicantStatusDTO.setUserId("user03");
		
		projectApplicantService.updateApplicantStatus(updateApplicantStatusDTO);
		
		ApplicantVO applicantVO = new ApplicantVO();
		applicantVO = projectApplicantService.getApplicant(2);
		
		Assert.assertEquals(2, applicantVO.getApplicantStatus());
	}

}