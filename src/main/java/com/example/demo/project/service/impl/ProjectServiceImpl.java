package com.example.demo.project.service.impl;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.GetProjectDTO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    @Qualifier("projectDAOImpl")
    ProjectDAO projectDAO;

    @Override
    public void addProject(ProjectVO projectVO) {
        projectDAO.addProject(projectVO);
    }

    @Override
    public ProjectVO getProject(GetProjectDTO getProjectDTO) {
        return projectDAO.getProject(getProjectDTO);
    }

    @Override
    public int addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return projectDAO.addProjectReply(projectReplyDTO);
    }

    @Override
    public MyProjectVO getMyProject(int projectNo) {
        return projectDAO.getMyProject(projectNo);
    }

    @Override
    public int addTodo(TodoVO todoVO) {
        return projectDAO.addTodo(todoVO);
    }

    @Override
    public int addBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return projectDAO.addBookmark(projectBookmarkDTO);
    }

    @Override
    public int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return projectDAO.deleteBookmark(projectBookmarkDTO);
    }

    @Override
    public List<ProjectVO> getProjectList(SearchVO searchVO) {
        return projectDAO.getProjectList(searchVO);
    }


}
