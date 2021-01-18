package com.example.demo.project.dao.impl;

import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.ReviewVO;
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
    public void addProject(ProjectVO projectVO) {
        sqlSession.insert("projectMapper.addProject", projectVO);
    }

    @Override
    public ProjectVO getProject(int projectNo) {
        return null;
    }

    @Override
    public void addReview(List<ReviewVO> reviewVO) {

    }
}
