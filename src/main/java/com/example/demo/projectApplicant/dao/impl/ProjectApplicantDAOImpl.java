package com.example.demo.projectApplicant.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dto.UpdateApplicantStatusDTO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dao.ProjectApplicantDAO;
import com.example.demo.projectApplicant.vo.ApplicantVO;

@Repository("projectApplicantDAOImpl")
public class ProjectApplicantDAOImpl implements ProjectApplicantDAO{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession() Call....");
	    System.out.println("TEST APP DAO@@@");
		this.sqlSession = sqlSession;
	 }
	
	//Constructor
	public ProjectApplicantDAOImpl() {
		System.out.println("::"+getClass()+".default Constructor Call....");
	}

	@Override
	public void addProject(ProjectVO projectVO) {
		sqlSession.insert("projectMapper.addProject",projectVO);
	}

	@Override
	public ProjectVO getProject(int projectNo) {
		return sqlSession.selectOne("projectMapper.getProject",projectNo);
	}

	@Override
	public void addApplicant(ApplicantVO applicantVO) {
		sqlSession.insert("applicantMapper.addApplicant",applicantVO);
	}

	@Override
	public ApplicantVO getApplicant(int applicantNo) {
		return sqlSession.selectOne("applicantMapper.getApplicant",applicantNo);
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
	public List<ApplicantVO> getApplicantList(SearchVO searchVO) {
		return sqlSession.selectList("applicantMapper.getApplicantList",searchVO);
	}

	@Override
	public int getTotalCount(SearchVO searchVO) {
		return sqlSession.selectOne("applicantMapper.getTotalCount", searchVO);
	}

}
