package com.example.demo.projectApplicant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.common.vo.SearchVO;

import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

public interface ProjectApplicantDAO {
	
	public void addProject(ProjectVO projectVO);
	
	public ProjectVO getProject(int projectNo);
	
	public void addApplicant(ApplicantVO applicantVO);

	public ApplicantVO getApplicant(int applicantNo);
	
	public List<ProjectVO> getAppliedProjectList(SearchVO searchVO);
	
	public List<ApplicantVO> getApplicantList(SearchVO searchVO);
	
	public List<ApplicantVO> getAppliedApplicantList(SearchVO searchVO);
	
	public void updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO);
	
	public void updateProjectMember(UpdateApplicantStatusDTO updateApplicantStatusDTO);
	
	public int getTotalCount(SearchVO searchVO);
	
	public int getAppliedTotalCount(SearchVO searchVO);
	
	public int getProjectNo(UpdateApplicantStatusDTO updateApplicantStatusDTO);
}
