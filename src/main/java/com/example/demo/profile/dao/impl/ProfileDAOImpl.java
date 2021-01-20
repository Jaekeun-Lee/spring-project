package com.example.demo.profile.dao.impl;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dao.ProfileDAO;
import com.example.demo.profile.dto.ProfileDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("profileDAOImpl")
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    @Override
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO){
        return sqlSession.insert("profileMapper.updateMyProfile", updateMyProfileDTO);
    }

    @Override
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId){
        return sqlSession.selectOne("profileMapper.getMyProfile", userId);
    }

    @Override
    public int updateLink(ProfileDTO.UpdateMyProfileDTO updateLink){
        return sqlSession.update("profileMapper.updateLink ", updateLink);
    }

}
