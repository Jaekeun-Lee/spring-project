package com.example.demo.projectApplicant.dao;

import com.example.demo.project.dto.UpdateApplicantStatusDTO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

public interface ProjectApplicantDAO {
	
	public void addProject(ProjectVO projectVO);
	
	public ProjectVO getProject(int projectNo);
	
	public void addApplicant(ApplicantVO applicantVO);

	public ApplicantVO getApplicant(int applicantNo);
	
//	public List<ProjectVO> getAppliedProjectList(SearchVO searchVO);
//	
//	public Map<String,Object> getApplicantList(SearchVO searchVO);
	
	public int updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO);
	
	public void updateProjectMember(int projectNo, String userId, int applicantNo, int applicantStatus);

}
