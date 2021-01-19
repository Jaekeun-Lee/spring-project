package com.example.demo.profile.dao;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;

public interface ProfileDAO {

    //기본정보 등록
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO);

    //기본정보 조회
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId);

}
