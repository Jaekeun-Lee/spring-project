package com.example.demo.project.service.impl;

import com.example.demo.common.vo.ReviewVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.*;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,Object> getProject(int projectNo, String userId) {

        Map<String, Object> getProjectMap = new HashMap<>();
        getProjectMap.put("projectNo", projectNo);
        getProjectMap.put("userId", userId);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("projectVO", projectDAO.getProject(getProjectMap));
        map.put("existApplicant", projectDAO.existApplicant(getProjectMap));

        return map;
    }

    @Override
    public ReplyVO addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return projectDAO.addProjectReply(projectReplyDTO);
    }

    @Override
    public MyProjectVO getMyProject(int projectNo) {
        return projectDAO.getMyProject(projectNo);
    }

    @Override
    public TodoVO addTodo(AddTodoDTO addTodoDTO) {
        return projectDAO.addTodo(addTodoDTO);
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
    public List<ProjectVO> getProjectList(ProjectSearchDTO projectSearchDTO) {
        projectSearchDTO.setUserId(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        return projectDAO.getProjectList(projectSearchDTO);
    }

    @Override
    public int deleteProject(int projectNo) {

        if (projectDAO.getMyProject(projectNo).getTeamMember().size() == 1) {
            return projectDAO.deleteProject(projectNo);
        } else {
            return 0;
        }

    }

    @Override
    public int withdrawProject(String userId) {
        return projectDAO.withdrawProject(userId);
    }

    @Override
    public int updateProjectLeader(Map<String ,Object> updateProjectLeaderMap) {
        return projectDAO.updateProjectLeader(updateProjectLeaderMap);
    }

    @Override
    public int addEndProjectCount(Map<String , Object> endProjectCountMap) {

        int teamMemberCnt =  Integer.parseInt((String)endProjectCountMap.get("teamMemberCnt"));
        int votedMemberCnt = Integer.parseInt((String)endProjectCountMap.get("votedMemberCnt"));
        if ( teamMemberCnt - 1 == votedMemberCnt) {
            projectDAO.updateProjectStatus(endProjectCountMap);
        }

        return projectDAO.addEndProjectCount(endProjectCountMap);

    }

    @Override
    public int addReview(AddReviewDTO addReviewDTO) {
        List<AddReviewDTO> addReviewDTOList = addReviewDTO.getReviewList();
        return projectDAO.addReview(addReviewDTOList);
    }

    @Override
    public int updateTodoStatus(Map updateTodoStatusMap) {
        return projectDAO.updateTodoStatus(updateTodoStatusMap);
    }

}
