package com.example.demo.projectApplicant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;


@RestController
@RequestMapping("/applicant/*")
public class ProjectApplicantRest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicantRest() {
		System.out.println(this.getClass());
	}

	@RequestMapping(value="json/updateApplicantStatus/{applicantStatus}/{applicantNo}", method=RequestMethod.GET)
	public ApplicantVO updateApplicantStatus(@ModelAttribute("updateApplicantStatusDTO")UpdateApplicantStatusDTO updateApplicantStatusDTO,
								HttpSession session) {
		System.out.println("@@@@@@@"+updateApplicantStatusDTO.getApplicantStatus());
		int applicantNo = updateApplicantStatusDTO.getApplicantNo();
		
		projectApplicantService.updateApplicantStatus(updateApplicantStatusDTO);
		ApplicantVO applicantVO = projectApplicantService.getApplicant(applicantNo);
		
		return applicantVO;
	}
	

}
