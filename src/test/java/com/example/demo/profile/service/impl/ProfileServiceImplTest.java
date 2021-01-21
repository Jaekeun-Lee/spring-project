package com.example.demo.profile.service.impl;

import com.example.demo.member.vo.MemberVO;
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
    public void updateMyProfile() {

        ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO = new ProfileDTO.UpdateMyProfileDTO();
        updateMyProfileDTO.setUserId("user02");
        updateMyProfileDTO.setProfileImg("abc.jpg");
        ProfileDTO.GetMyProfileDTO getMyProfileDTO = profileService.getMyProfile("user02");

        String link = "www.cyworld.net";
        String csvLink = getMyProfileDTO.getLink()+","+link;
        updateMyProfileDTO.setLink(csvLink);
        System.out.println(getMyProfileDTO.getLink());

        updateMyProfileDTO.setSelfIntro("설명중입니다~");

        Assert.assertEquals(1,profileService.updateMyProfile(updateMyProfileDTO));
    }

    //@Test
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

    //@Test
    public void deleteMyProfile(){
        ProfileDTO.UpdateMyProfileDTO deleteMyProfileDTO = new ProfileDTO.UpdateMyProfileDTO();
        deleteMyProfileDTO.setUserId("user01");

        Assert.assertEquals(1,profileService.updateMyProfile(deleteMyProfileDTO));
    }


}