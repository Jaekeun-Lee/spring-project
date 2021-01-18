package com.example.demo.project.dao;

import com.example.demo.project.vo.ProjectVO;
import com.example.demo.common.vo.ReviewVO;

import java.util.List;

public interface ProjectDAO {

    //프로젝트 등록
    public void addProject(ProjectVO projectVO);

    //프로젝트 상세정보 조회
    public ProjectVO getProject(int projectNo);

    public void addReview(List<ReviewVO> reviewVO);

    //Rest - DTO
    //public void addProjectReply(ReplyDTO replyDTO);

    //Rest - DTO
    //public void addBookmark(BookmarkDTO bookmarkDTO);

}
