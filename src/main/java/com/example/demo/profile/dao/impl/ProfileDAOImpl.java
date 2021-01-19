package com.example.demo.profile.dao.impl;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dao.ProfileDAO;
import com.example.demo.profile.dto.ProfileDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("profileDAOImpl")
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO){
        return sqlSession.insert("profileMapper.updateMyProfile", updateMyProfileDTO);
    }

    public MemberVO getMyProfile(ProfileDTO profileDTO){
        return sqlSession.selectOne("profileMapper.getMyProfile", profileDTO);
    }
}
