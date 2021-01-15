package com.example.demo.project.service;

import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.ReviewVO;
import com.example.demo.project.vo.TodoVO;

import java.util.List;

public interface ProjectService {

    public void addProject(ProjectVO projectVO);

    public ProjectVO getProject(int projectNo);

    public void addReview(List<ReviewVO> reviewVO);

    //Rest - DTO
    //public void addProjectReply(ReplyDTO replyDTO);

    //Rest - DTO
    //public void addBookmark(BookmarkDTO bookmarkDTO);

    public void addTodoList(TodoVO todoVO);

    public ProjectVO getMyProject(int userId);

    //public String getProjectFile(String fileName);

    //public List<ProjectVO> getProjectList(SearchVO searchVO);

    public void updateProjectLeader(ProjectVO projectVO, String userId);

    public void updateProjectStatus();

    public void deleteProject(int projectNo);


    //private ProjectVO getCompletedProjectList(SearchVO searchVO);



}
