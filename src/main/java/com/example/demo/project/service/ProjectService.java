package com.example.demo.project.service;

import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.ReviewVO;
import com.example.demo.project.vo.TodoVO;

import java.util.List;

public interface ProjectService {
    //프로젝트 등록
    public void addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    public ProjectVO getProject(int projectNo);

    public void addReview(List<ReviewVO> reviewVO);


    public void addProjectReply(ProjectReplyDTO projectReplyDTO);

    //Rest - DTO
    //public void addBookmark(BookmarkDTO bookmarkDTO);

    public void addTodoList(TodoVO todoVO);

    public ProjectVO getMyProject(int userId);

    //파일 다운로드 - 보류
    //public String getProjectFile(String fileName);

    //public List<ProjectVO> getProjectList(SearchVO searchVO);


    public void updateProjectLeader(ProjectVO projectVO, String userId);


    //이거
    public void updateProjectStatus();

    public void deleteProject(int projectNo);


    //private ProjectVO getCompletedProjectList(SearchVO searchVo);



}
