package com.example.demo.projectApplicant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
		System.out.println("TEST APP SERVICE @@@@@");
		this.projectapplicantDAO = projectapplicantDAO;
	}
	
	//Constructor
	public ProjectApplicantServiceImpl() {
		System.out.println("::"+getClass()+".default Constructor Call....");
	}
	
	@Override
	public void addProject(ProjectVO projectVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProjectVO getProject(int projectNo) {
		System.out.println("@@@@@@@@@");
		return projectapplicantDAO.getProject(projectNo);
	}

	@Override
	public void addApplicant(ApplicantVO applicantVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ApplicantVO getApplicant(int applicantNo) {
		// TODO Auto-generated method stub
		return null;
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

}
