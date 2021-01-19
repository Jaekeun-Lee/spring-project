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

    //@Test
    public void addMyProfile() {

        ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO = new ProfileDTO.UpdateMyProfileDTO();
        updateMyProfileDTO.setUserId("user01");
        updateMyProfileDTO.setProfileImg("choco.jpg");
        updateMyProfileDTO.setLink("www.intellij.com");
        updateMyProfileDTO.setSelfIntro("안녕안녕");

        Assert.assertEquals(1,profileService.updateMyProfile(updateMyProfileDTO));
    }

    @Test
    public void getMyProfile() {
        ProfileDTO.GetMyProfileDTO getMyProfileDTO = new ProfileDTO.GetMyProfileDTO();

        getMyProfileDTO = profileService.getMyProfile("user01");

        Assert.assertEquals("user01", getMyProfileDTO.getUserId());
        Assert.assertEquals("user01@test.com", getMyProfileDTO.getEmail());
        Assert.assertEquals("choco.jpg",getMyProfileDTO.getProfileImg());
        Assert.assertEquals("이재근",getMyProfileDTO.getName());
        Assert.assertEquals("BRONZE",getMyProfileDTO.getGrade());
        Assert.assertEquals(4,getMyProfileDTO.getReportCnt());
        Assert.assertEquals("안녕안녕",getMyProfileDTO.getSelfIntro());
        Assert.assertEquals("www.intellij.com",getMyProfileDTO.getLink());


    }
}