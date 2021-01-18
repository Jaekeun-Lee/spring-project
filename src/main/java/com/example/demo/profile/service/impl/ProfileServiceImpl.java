package com.example.demo.profile.service.impl;

import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dao.ProfileDAO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    @Qualifier("profileDAOImpl")
    ProfileDAO profileDAO;

    @Override
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO) {
        return profileDAO.updateMyProfile(updateMyProfileDTO);
    }

    @Override
    public MemberVO getMyProfile(ProfileDTO profileDTO) {
        return profileDAO.getMyProfile(profileDTO);
    }
}
