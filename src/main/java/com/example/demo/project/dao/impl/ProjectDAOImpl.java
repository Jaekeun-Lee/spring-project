package com.example.demo.project.dao.impl;

import com.example.demo.common.vo.ReviewVO;
import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.dao.ProjectDAO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.project.vo.TodoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository("projectDAOImpl")
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    private final String NAMESPACE = "projectMapper.";

    @Override
    public void addProject(ProjectVO projectVO) {
        sqlSession.insert(NAMESPACE + "addProject", projectVO);
        sqlSession.update(NAMESPACE + "updateMemberProjectNo", projectVO.getLeaderId());
    }

    @Override
    public ProjectVO getProject(Map<String, Object> getProjectMap) {
        sqlSession.update(NAMESPACE + "updateViewCnt", getProjectMap);
        return sqlSession.selectOne(NAMESPACE + "getProject", getProjectMap);
    }

    @Override
    public int addProjectReply(ProjectReplyDTO projectReplyDTO) {
        return sqlSession.insert(NAMESPACE + "addProjectReply", projectReplyDTO);
    }

    @Override
    public MyProjectVO getMyProject(int projectNo) {
        return sqlSession.selectOne(NAMESPACE + "getMyProject", projectNo);
    }

    @Override
    public int addTodo(TodoVO todoVO) {
        return sqlSession.insert(NAMESPACE + "addTodo", todoVO);
    }

    @Override
    public int addBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return sqlSession.insert(NAMESPACE + "addBookmark", projectBookmarkDTO);
    }

    @Override
    public int deleteBookmark(ProjectBookmarkDTO projectBookmarkDTO) {
        return sqlSession.delete(NAMESPACE + "deleteBookmark", projectBookmarkDTO);
    }

    @Override
    public List<ProjectVO> getProjectList(SearchVO searchVO) {
        return sqlSession.selectList(NAMESPACE + "getProjectList", searchVO);
    }

    @Override
    public int deleteProject(int projectNo) {
        return sqlSession.delete(NAMESPACE + "deleteProject", projectNo);
    }

    @Override
    public int withdrawProject(String userId) {
        return sqlSession.update(NAMESPACE + "withdrawProject", userId);
    }

    @Override
    public int updateProjectLeader(Map<String, Object> updateProjectLeaderMap) {
        sqlSession.update(NAMESPACE + "updateProjectLeader", updateProjectLeaderMap);
        return sqlSession.update(NAMESPACE + "updateMemberProjectToNull", updateProjectLeaderMap.get("beforeLeaderId"));

    }

    @Override
    public int addEndProjectCount(Map<String, Object> addEndProjectCountMap) {
        return sqlSession.insert(NAMESPACE + "addEndProjectCount", addEndProjectCountMap);
    }

    @Override
    public int updateProjectStatus(Map<String, Object> updateProjectStatusMap) {
        return sqlSession.update(NAMESPACE + "updateProjectStatus", updateProjectStatusMap);
    }

    @Override
    public int addReview(List<ReviewVO> reviewVOList) {
        return sqlSession.insert(NAMESPACE + "addReview", reviewVOList);
    }


}
