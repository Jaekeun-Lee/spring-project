package com.example.demo.project.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    //프로젝트 등록
    void addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    ProjectVO getProject(Map<String, Object> getProjectMap);

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

    //프로젝트 삭제
    int deleteProject(int projectNo);

    //int withdrawProject(MemberVO ? );
    //void updateProjectLeader(ProjectVO projectVO, String userId);

    //프로젝트 상태 변경 스프링 스케줄러
    //void updateProjectStatus();

    //void addReview(List<ReviewVO> reviewVO);

    //파일 다운로드 - 보류
    //String getProjectFile(String fileName);





}
