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

import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.member.vo.MemberVO;
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
							   Model model) {
		System.out.println("/addApplicant");
		System.out.println(applicantVO);
		projectApplicantService.addApplicant(applicantVO);
		
		return "redirect:../project/getProject?projectNo="+applicantVO.getProjectVO().getProjectNo();
	}
	
	@RequestMapping(value = "/applicantList", method = RequestMethod.GET)
	public String applicantList(@ModelAttribute("searchVO") SearchVO searchVO,
								Model model,
								HttpSession session) throws Exception{
		System.out.println("/applicantList GET");
		searchVO.setPageSize(4);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		
		Map<String , Object> map=projectApplicantService.getApplicantList(searchVO);
		
		model.addAttribute("applicantList", map.get("list"));
		
		return "projectApplicant/applicantList";
	}
	
	@RequestMapping(value = "/appliedProjectList", method = RequestMethod.GET)
	public String appliedProjectList(@ModelAttribute("searchVO") SearchVO searchVO,
									Model model,
									HttpSession session)throws Exception{
		System.out.println("/appliedProjectList GET");
		
		searchVO.setPageSize(3);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, 3);
		System.out.println(resultPage);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		return "projectApplicant/appliedProjectList";
	}
	
	@RequestMapping(value = "/endProjectList", method = RequestMethod.GET)
	public String endProjectList(@ModelAttribute("searchVO") SearchVO searchVO,
								 Model model,
								 HttpSession session)throws Exception{
		System.out.println("/endProjectList GET");
		searchVO.setPageSize(3);
		searchVO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		searchVO.setSearchConditionB(6);
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(1);
		}
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, 3);
		System.out.println(resultPage);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		return "projectApplicant/endProjectList";
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
