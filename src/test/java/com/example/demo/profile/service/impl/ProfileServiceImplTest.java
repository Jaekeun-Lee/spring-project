package com.example.demo.profile.service.impl;

import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceImplTest {

    @Autowired
    @Qualifier("profileServiceImpl")
    private ProfileService profileService;

    @Test
    public void addMyProfile() {

        ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO = new ProfileDTO.UpdateMyProfileDTO();
        updateMyProfileDTO.setUserId("user01");
        //updateMyProfileDTO.setProfileImg();
        updateMyProfileDTO.setLink("www.daum.net");
        updateMyProfileDTO.setSelfIntro("hi");

        Assert.assertEquals(1,profileService.updateMyProfile(updateMyProfileDTO));
    }

    //@Test
    public void getMyProfile() {
    }
}