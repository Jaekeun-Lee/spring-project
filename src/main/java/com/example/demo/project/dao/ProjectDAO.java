package com.example.demo.project.dao;

import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;

public interface ProjectDAO {

    //프로젝트 등록
    int addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    ProjectVO getProject(int projectNo);

    //프로젝트 댓글 작성
    int addProjectReply(ProjectReplyDTO projectReplyDTO);

    //진행중인 프로젝트 조회
    MyProjectVO getMyProject(int projectNo);

    //TodoList 추가
    int addTodo(TodoVO todoVO);


    //Rest - DTO
    //public void addBookmark(BookmarkDTO bookmarkDTO);

    //public void addTodoList(TodoVO todoVO);

    //public ProjectVO getMyProject(int userId);

    //파일 다운로드 - 보류
    //public String getProjectFile(String fileName);

    //public List<ProjectVO> getProjectList(SearchVO searchVO);


    //public void updateProjectLeader(ProjectVO projectVO, String userId);


    //이거
    //public void updateProjectStatus();

    //public void deleteProject(int projectNo);


    //private ProjectVO getCompletedProjectList(SearchVO searchVo);

}
