package com.example.demo.projectApplicant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;

@Controller
@RequestMapping("/applicant/*")
public class ProjectApplicantRest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicantRest() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/json/addApplicant")
	public String addApplicant(@ModelAttribute("applicant") ApplicantVO applicantVO) {
		System.out.println("/json/addApplicant");
		System.out.println("@@@@@@@"+applicantVO);
		//projectApplicantService.addApplicant(applicantVO);
		
		return "welcome";
	}

}
