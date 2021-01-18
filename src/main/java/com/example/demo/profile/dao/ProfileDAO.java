package com.example.demo.profile.dao;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;

public interface ProfileDAO {

    //기본정보 등록
    public int addMyProfile(MemberVO memberVO);

    //기본정보 조회
    public MemberVO getMyProfile(ProfileDTO profileDTO);

}
