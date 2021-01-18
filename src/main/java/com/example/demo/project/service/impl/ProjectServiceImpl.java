package com.example.demo.project.service.impl;

import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    @Qualifier("projectDAOImpl")
    ProjectDAO projectDAO;

    public void addProject(ProjectVO projectVO) {
        projectDAO.addProject(projectVO);
    }

    public ProjectVO getProject(int projectNo) {
        return null;
    }

    @Override
    public void addReview(List<ReviewVO> reviewVO) {

    }

    @Override
    public void addProjectReply(ProjectReplyDTO projectReplyDTO) {

    }

    @Override
    public void addTodoList(TodoVO todoVO) {

    }

    @Override
    public ProjectVO getMyProject(int userId) {
        return null;
    }

    @Override
    public void updateProjectLeader(ProjectVO projectVO, String userId) {

    }

    @Override
    public void updateProjectStatus() {

    }

    @Override
    public void deleteProject(int projectNo) {

    }

}
