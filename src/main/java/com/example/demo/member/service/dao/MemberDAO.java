package com.example.demo.member.service.dao;


import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.net.ssl.SSLSession;
import java.util.List;

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

    public List<MemberVO> selectMemberList(MemberVO param) {
        return sqlSession.selectList("member.selectMemberList", param);
    }

    public List<MemberVO> selectMemberReportList(MemberVO param) {
        return sqlSession.selectList("member.selectReportMemberList", param);
    }

    public List<MemberVO> selectMemberDormantList(MemberVO param) {
        return sqlSession.selectList("selectDormantMemberList", param);
    }

}

