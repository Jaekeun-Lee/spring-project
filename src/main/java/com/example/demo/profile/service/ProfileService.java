package com.example.demo.profile.service;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;

public interface ProfileService {

    //기본정보 등록
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO);

    //기본정보 조회
    public MemberVO getMyProfile(ProfileDTO profileDTO);

}
