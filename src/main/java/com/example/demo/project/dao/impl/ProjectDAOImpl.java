package com.example.demo.project.dao.impl;

import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.common.vo.ReviewVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("projectDAOImpl")
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    @Override
    public int addProject(ProjectVO projectVO) {
        return sqlSession.insert("projectMapper.addProject", projectVO);
    }

    @Override
    public ProjectVO getProject(int projectNo) {
        return sqlSession.selectOne("projectMapper.getProject",projectNo);
    }

    @Override
    public int addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return sqlSession.insert("projectMapper.addProjectReply",projectReplyDTO);
    }



}
