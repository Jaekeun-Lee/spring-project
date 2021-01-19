package com.example.demo.projectApplicant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dto.UpdateApplicantStatusDTO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dao.ProjectApplicantDAO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;

@Service("projectApplicantServiceImpl")
public class ProjectApplicantServiceImpl implements ProjectApplicantService{
	
	@Autowired
	@Qualifier("projectApplicantDAOImpl")
	ProjectApplicantDAO projectapplicantDAO;
	public void setProjectapplicantDAO(ProjectApplicantDAO projectapplicantDAO) {
		System.out.println("::"+getClass()+".projectApplicantDAOImpl Call....");
		this.projectapplicantDAO = projectapplicantDAO;
	}
	
	//Constructor
	public ProjectApplicantServiceImpl() {
		System.out.println("::"+getClass()+".default Constructor Call....");
	}
	
	@Override
	public void addProject(ProjectVO projectVO) {
		projectapplicantDAO.addProject(projectVO);
	}

	@Override
	public ProjectVO getProject(int projectNo) {
		return projectapplicantDAO.getProject(projectNo);
	}

	@Override
	public void addApplicant(ApplicantVO applicantVO) {
		projectapplicantDAO.addApplicant(applicantVO);
	}

	@Override
	public ApplicantVO getApplicant(int applicantNo) {
		return projectapplicantDAO.getApplicant(applicantNo);
	}

	@Override
	public int updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProjectMember(int projectNo, String userId, int applicantNo, int applicantStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getApplicantList(SearchVO searchVO) {
		List<ApplicantVO> list = projectapplicantDAO.getApplicantList(searchVO);
		int totalCount = projectapplicantDAO.getTotalCount(searchVO);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		return map;
	}

	@Override
	public Map<String, Object> getAppliedProjectList(SearchVO searchVO) {
		List<ProjectVO> list1 = projectapplicantDAO.getAppliedProjectList(searchVO);
		List<ApplicantVO> list2 = projectapplicantDAO.getAppliedApplicantList(searchVO);
		int totalCount = projectapplicantDAO.getAppliedTotalCount(searchVO);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("totalCount", new Integer(totalCount));
		return map;
	}

}
