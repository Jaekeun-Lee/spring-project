package com.example.demo.projectApplicant.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;



public class ProjectApplicantTest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicantTest() {
		System.out.println("TEST APP @@@@@");
	}
	
	@Test
	public void GetProject() throws Exception{
		
		ProjectVO projectVO = new ProjectVO();
		
		projectVO = projectApplicantService.getProject(1);
		System.out.println(projectVO);
		
		Assert.assertEquals("testProject", projectVO.getProjectName());
	}
	

}