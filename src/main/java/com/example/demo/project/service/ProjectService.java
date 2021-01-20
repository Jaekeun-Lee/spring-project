package com.example.demo.project.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dto.GetProjectDTO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;

import java.util.List;

public interface ProjectService {

    //프로젝트 등록
    void addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    ProjectVO getProject(GetProjectDTO getProjectDTO);

    //프로젝트 댓글 작성
    int addProjectReply(ProjectReplyDTO projectReplyDTO);

    //진행중인 프로젝트 조회
    MyProjectVO getMyProject(int projectNo);

    //TodoList 추가
    int addTodo(TodoVO todoVO);

    //BookMark 추가
    int addBookmark(ProjectBookmarkDTO projectBookmarkDTO);

    //BookMark 삭제
    int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO);

    //프로젝트 목록 조회
    List<ProjectVO> getProjectList(SearchVO searchVO);

    //public void addReview(List<ReviewVO> reviewVO);




    //파일 다운로드 - 보류
    //public String getProjectFile(String fileName);




    //public void updateProjectLeader(ProjectVO projectVO, String userId);


    //이거
    //public void updateProjectStatus();

    //public void deleteProject(int projectNo);





}
