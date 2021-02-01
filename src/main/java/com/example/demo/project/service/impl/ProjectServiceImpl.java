package com.example.demo.project.service.impl;

import com.example.demo.common.vo.ReviewVO;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.dto.ProjectSearchDTO;
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
    public ProjectVO getProject(int projectNo, String userId) {

        Map<String, Object> getProjectMap = new HashMap<>();

        getProjectMap.put("projectNo", projectNo);
        getProjectMap.put("userId", userId);

        return projectDAO.getProject(getProjectMap);

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
    public int updateProjectLeader(int projectNo, String beforeLeaderId, String afterLeaderId) {

        Map<String, Object> updateProjectLeaderMap = new HashMap<>();

        updateProjectLeaderMap.put("projectNo", projectNo);
        updateProjectLeaderMap.put("beforeLeaderId", beforeLeaderId);
        updateProjectLeaderMap.put("afterLeaderId", afterLeaderId);


        return projectDAO.updateProjectLeader(updateProjectLeaderMap);
    }

    @Override
    public int addEndProjectCount(int projectNo, String userId, int teamMemberCnt, int votedMemberCnt) {

        Map<String, Object> map = new HashMap<>();

        map.put("projectNo", projectNo);
        map.put("userId", userId);

        if (teamMemberCnt - 1 == votedMemberCnt) {
            projectDAO.updateProjectStatus(map);
        }

        return projectDAO.addEndProjectCount(map);

    }

    @Override
    public int addReview(List<ReviewVO> reviewVOList) {
        return projectDAO.addReview(reviewVOList);
    }

}
