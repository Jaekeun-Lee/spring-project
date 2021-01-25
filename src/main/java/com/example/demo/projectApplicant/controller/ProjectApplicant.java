package com.example.demo.projectApplicant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;

@Controller
@RequestMapping("/applicant/*")
public class ProjectApplicant {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicant() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value = "/addApplicant", method = RequestMethod.GET)
	public String addProject() throws Exception{
		System.out.println("/addApplicant GET");
		return "projectApplicant/addApplicant";
	}
	
//	@RequestMapping(value = "/addApplicant", method = RequestMethod.GET)
//	public String addProject(@ModelAttribute("project")ProjectVO projectVO, Model model) throws Exception{
//		System.out.println("/addApplicant GET");
//		System.out.println(projectVO);
//		
//		model.addAttribute("projectVO",projectVO);
//		
//		return "projectApplicant/addApplicant";
//	}
}
