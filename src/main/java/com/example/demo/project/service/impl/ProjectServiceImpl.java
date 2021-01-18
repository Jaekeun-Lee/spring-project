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

    @Override
    public int addProject(ProjectVO projectVO) {
        return projectDAO.addProject(projectVO);
    }

    @Override
    public ProjectVO getProject(int projectNo) {
        return projectDAO.getProject(projectNo);
    }

    @Override
    public int addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return projectDAO.addProjectReply(projectReplyDTO);
    }


}
