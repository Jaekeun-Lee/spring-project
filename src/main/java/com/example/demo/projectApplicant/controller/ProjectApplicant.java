package com.example.demo.projectApplicant.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
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
	public String addApplicant() throws Exception{
		System.out.println("/addApplicant GET");
		return "projectApplicant/addApplicant";
	}
	
	@RequestMapping(value="/addApplicant", method=RequestMethod.POST)
	public String addApplicant(@ModelAttribute("applicant") ApplicantVO applicantVO,
							   HttpSession session) {
		System.out.println("/addApplicant");
		System.out.println(applicantVO);
		//projectApplicantService.addApplicant(applicantVO);
		
		return "welcome";
	}
	
	@RequestMapping(value = "/applicantList", method = RequestMethod.GET)
	public String applicantList(@ModelAttribute("searchVO") SearchVO searchVO,
								Model model) throws Exception{
		System.out.println("/applicantList GET");
		searchVO.setPageSize(6);
		searchVO.setUserId("user01");
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		
		Map<String , Object> map=projectApplicantService.getApplicantList(searchVO);
		
		model.addAttribute("applicantList", map.get("list"));
		
		System.out.println(map.get("list"));
		
		//return "projectApplicant/applicantList";
		return "projectApplicant/applicantList";
	}
	
	@RequestMapping(value = "/getApplicant", method = RequestMethod.GET)
	public String getApplicant(@RequestParam("applicantNo")String applicantNo,
							   Model model)throws Exception {
		int intApplicantNo = Integer.parseInt(applicantNo);
		ApplicantVO applicantVO = projectApplicantService.getApplicant(intApplicantNo);
		
		model.addAttribute("applicantVO",applicantVO);
		return "projectApplicant/getApplicant";
	}
	
	@RequestMapping(value = "/updateApplicantStatus", method = RequestMethod.GET)
	public String updateApplicantStatus(@ModelAttribute("updateApplicantStatusDTO")UpdateApplicantStatusDTO updateApplicantStatusDTO,
										HttpSession session) {
		updateApplicantStatusDTO.setUserId("user03");
		System.out.println("hi");
		System.out.println(updateApplicantStatusDTO);
		//projectApplicantService.updateApplicantStatus(updateApplicantStatusDTO);
		return null;
	}
	
}
