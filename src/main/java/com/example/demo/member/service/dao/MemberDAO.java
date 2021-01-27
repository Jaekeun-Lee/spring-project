package com.example.demo.member.service.dao;


import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.net.ssl.SSLSession;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final SqlSession sqlSession;


    /**
     * 성공일때 return - 1
     *
     * @param member
     * @return
     */
    public int addMember(MemberVO member) {
        return sqlSession.insert("member.addMember", member);
    }

    public MemberVO selectMember(String userId) {
        return sqlSession.selectOne("member.selectMember", userId);
    }

    public List<MemberVO> selectMemberList(MemberVO param) {
        return sqlSession.selectList("member.selectMemberList", param);
    }

    public List<MemberVO> selectMemberReportList(MemberVO param) {
        return sqlSession.selectList("member.selectReportMemberList", param);
    }

    public List<MemberVO> selectMemberDormantList(MemberVO param) {
        return sqlSession.selectList("member.selectDormantMemberList", param);
    }

    public List<MemberVO> selectMemberBackList(MemberVO param) {
        return sqlSession.selectList("member.selectBlackMemberList", param);
    }

    public int deleteMember(MemberVO member) {
        return sqlSession.delete("member.deleteMember", member);
    }


    public MemberVO findUserByUserId(String email) {
        return null;
    }

    public MemberVO findUserByUserPassword(Map<String, Object> param) {
        return sqlSession.selectOne("member.selectFindUserByPassword", param);
    }

    public void updateUserPassword(String id, String password) {
    }
}



