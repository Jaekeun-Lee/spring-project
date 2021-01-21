package com.example.demo.common.vo;

import com.example.demo.community.vo.PostVO;
import com.example.demo.project.vo.ProjectVO;

import java.util.List;

public class BookmarkVO {
    private int bookmarkNo;
    private String userId;
    private List<ProjectVO> projectVO;
    private List<PostVO> postVO;

    public BookmarkVO() {
    }

    public int getBookmarkNo() {
        return bookmarkNo;
    }

    public void setBookmarkNo(int bookmarkNo) {
        this.bookmarkNo = bookmarkNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ProjectVO> getProjectVO() {
        return projectVO;
    }

    public void setProjectVO(List<ProjectVO> projectVO) {
        this.projectVO = projectVO;
    }

    public List<PostVO> getPostVO() {
        return postVO;
    }

    public void setPostVO(List<PostVO> postVO) {
        this.postVO = postVO;
    }

    @Override
    public String toString() {
        return "BookmarkVO{" +
                "bookmarkNo=" + bookmarkNo +
                ", userId='" + userId + '\'' +
                ", projectVO=" + projectVO +
                ", postVO=" + postVO +
                '}';
    }
}
