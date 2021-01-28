package com.example.demo.project.dao;

import com.example.demo.common.vo.ReviewVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;

import java.util.List;
import java.util.Map;

public interface ProjectDAO {

    //프로젝트 등록
    int addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    ProjectVO getProject(Map<String, Object> getProjectMap);

    //프로젝트 댓글 작성
    ReplyVO addProjectReply(ProjectReplyDTO projectReplyDTO);

    //진행중인 프로젝트 조회
    MyProjectVO getMyProject(int projectNo);

    //TodoList 추가
    int addTodo(TodoVO todoVO);

    //Bookmark 추가
    int addBookmark(ProjectBookmarkDTO projectBookmarkDTO);

    //Bookmark 삭제
    int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO);

    //프로젝트 목록 조회
    List<ProjectVO> getProjectList(SearchVO searchVO);

    //프로젝트 삭제
    int deleteProject(int projectNo);

    //프로젝트 탈퇴
    int withdrawProject(String userId);

    //팀장 프로젝트 탈퇴 ( 권한 위임 )
    int updateProjectLeader(Map<String, Object> updateProjectLeaderMap);

    //프로젝트 종료 투표
    int addEndProjectCount(Map<String, Object> addEndProjectCountMap);

    //프로젝트 상태 변경
    int updateProjectStatus(Map<String, Object> updateProjectStatusMap);

    //리뷰 작성
    int addReview(List<ReviewVO> reviewVOList);


}
