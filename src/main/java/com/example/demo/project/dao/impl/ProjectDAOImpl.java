package com.example.demo.project.dao.impl;

import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
        return sqlSession.selectOne("projectMapper.getProject", projectNo);
    }

    @Override
    public int addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return sqlSession.insert("projectMapper.addProjectReply", projectReplyDTO);
    }

    @Override
    public MyProjectVO getMyProject(int projectNo) {
        return sqlSession.selectOne("projectMapper.getMyProject", projectNo);
    }

    @Override
    public int addTodo(TodoVO todoVO) {
        return sqlSession.insert("projectMapper.addTodo", todoVO);
    }


}
