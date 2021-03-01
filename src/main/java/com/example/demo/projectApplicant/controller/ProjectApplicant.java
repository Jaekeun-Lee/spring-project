package com.example.demo.projectApplicant.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.controller.Project;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/applicant/*")
@Slf4j
public class ProjectApplicant {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	@Autowired
    @Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	private final int DEFAULT_PAGE = 1;
    private final int PAGE_SIZE = 10;
	
	public ProjectApplicant() {
		System.out.println(this.getClass());
	}
	
	@GetMapping("/addApplicant")
	public String addApplicant() throws Exception{
		return "projectApplicant/addApplicant";
	}
	
	@PostMapping("/addApplicant")
	public String addApplicant(@ModelAttribute("applicant") ApplicantVO applicantVO,
							   Model model) {
		projectApplicantService.addApplicant(applicantVO);
		return "redirect:../project/getProject?projectNo="+applicantVO.getProjectVO().getProjectNo();
	}
	
	@GetMapping("/applicantList")
	public String applicantList(@ModelAttribute("searchVO") SearchVO searchVO,
								Model model,
								HttpSession session) throws Exception{
		searchVO.setPageSize(PAGE_SIZE);
		searchVO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(DEFAULT_PAGE);
		}
		
		Map<String , Object> map=projectApplicantService.getApplicantList(searchVO);
		//( currentPage, totalCount, pageUnit, pageSize )
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, PAGE_SIZE);	
		
		model.addAttribute("applicantList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		
		return "projectApplicant/applicantList";
	}
	
	@GetMapping("/appliedProjectList")
	public String appliedProjectList(@ModelAttribute("searchVO") SearchVO searchVO,
									Model model,
									HttpSession session)throws Exception{
		searchVO.setPageSize(PAGE_SIZE);
		searchVO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(DEFAULT_PAGE);
		}
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		//( currentPage, totalCount, pageUnit, pageSize )
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, PAGE_SIZE);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		return "projectApplicant/appliedProjectList";
	}
	
	@GetMapping("/endProjectList")
	public String endProjectList(@ModelAttribute("searchVO") SearchVO searchVO,
								 Model model,
								 HttpSession session)throws Exception{
		searchVO.setPageSize(PAGE_SIZE);
		searchVO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
		searchVO.setSearchConditionB(6);
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(DEFAULT_PAGE);
		}
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, PAGE_SIZE);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		return "projectApplicant/endProjectList";
	}
	
	@GetMapping("/getApplicant")
	public String getApplicant(@RequestParam("applicantNo")String applicantNo,
							   Model model)throws Exception {
		int intApplicantNo = Integer.parseInt(applicantNo);
		ApplicantVO applicantVO = projectApplicantService.getApplicant(intApplicantNo);
		
		model.addAttribute("applicantVO",applicantVO);
		return "projectApplicant/getApplicant";
	}
	
	@GetMapping("/updateApplicantStatus")
	public String updateApplicantStatus(@ModelAttribute("updateApplicantStatusDTO")UpdateApplicantStatusDTO updateApplicantStatusDTO,
										@ModelAttribute("searchVO") SearchVO searchVO,
										Model model,
										HttpSession session) {
		updateApplicantStatusDTO.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
		int applicantNo = updateApplicantStatusDTO.getApplicantNo();
		
		projectApplicantService.updateApplicantStatus(updateApplicantStatusDTO);
		ApplicantVO applicantVO = projectApplicantService.getApplicant(applicantNo);
		
		session.removeAttribute("user");
        MemberVO memberVO = memberService.selectMember(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        if (memberVO != null) {
            session.setAttribute("user", memberVO);
        }
        
		searchVO.setPageSize(PAGE_SIZE);
		searchVO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
		if(searchVO.getCurrentPage() == 0 ){
			searchVO.setCurrentPage(DEFAULT_PAGE);
		}
		
		Map<String , Object> map=projectApplicantService.getAppliedProjectList(searchVO);
		PageVO resultPage = new PageVO( searchVO.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), 5, PAGE_SIZE);
		
		model.addAttribute("appliedList", map.get("list"));
		model.addAttribute("resultPage", resultPage);
        
        return "projectApplicant/applicantList";
	}
	
}
