package com.example.demo.projectApplicant.dao;

import static org.junit.jupiter.api.Assertions.*;

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

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicantDAOTest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicantDAOTest() {
		System.out.println("TEST APP @@@@@");
	}
	
	@Test
	public void getProject(){
		
		ProjectVO projectVO = new ProjectVO();
		
		projectVO = projectApplicantService.getProject(1);
		System.out.println(projectVO);
		
		Assert.assertEquals("testProject", projectVO.getProjectName());
		Assert.assertEquals(3, projectVO.getProjectReply().get(0).getReplyNo());
		Assert.assertEquals(2,projectVO.getProjectReply().size());
		Assert.assertEquals(2,projectVO.getApplicantsCnt());
	}
	

}