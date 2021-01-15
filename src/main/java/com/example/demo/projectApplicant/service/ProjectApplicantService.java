package com.example.demo.projectApplicant.service;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.dto.UpdateApplicantStatusDTO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

import java.util.List;
import java.util.Map;

public interface ProjectApplicantService {
	
	public void addProject(ProjectVO projectVO);
	
	public ProjectVO getProject(int projectNo);

    public void addApplicant(ApplicantVO applicantVO);

    public ApplicantVO getApplicant(int applicantNo);

//    public List<ProjectVO> getAppliedProjectList(SearchVO searchVO);

//    public Map<String,Object> getApplicantList(SearchVO searchVO);

    //Rest - DTO
    public int updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO);

    public void updateProjectMember(int projectNo, String userId, int applicantNo, int applicantStatus);


}

