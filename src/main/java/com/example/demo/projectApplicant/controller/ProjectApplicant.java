package com.example.demo.projectApplicant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;

@Controller
@RequestMapping("/applicant/*")
public class ProjectApplicant {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicant() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String addProject() throws Exception{
		System.out.println("/addProject GET");
		return "projectApplicant/addProjectView";
	}
	
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("project")ProjectVO projectVO) throws Exception{
		System.out.println("/addProject POST");
		return "forward:/applicant/수정수정.html";
	}
}
