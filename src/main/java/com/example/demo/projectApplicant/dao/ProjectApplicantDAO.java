package com.example.demo.projectApplicant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.common.vo.SearchVO;

import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

public interface ProjectApplicantDAO {
	
	void addProject(ProjectVO projectVO);
	
	ProjectVO getProject(int projectNo);
	
	void addApplicant(ApplicantVO applicantVO);

	ApplicantVO getApplicant(int applicantNo);
	
	List<ApplicantVO> getApplicantList(SearchVO searchVO);
	
	List<ApplicantVO> getAppliedApplicantList(SearchVO searchVO);
	
	void updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO);
	
	void updateProjectMember(UpdateApplicantStatusDTO updateApplicantStatusDTO);
	
	int getTotalCount(SearchVO searchVO);
	
	int getAppliedTotalCount(SearchVO searchVO);

}
