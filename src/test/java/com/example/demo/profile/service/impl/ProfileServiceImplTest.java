package com.example.demo.profile.service.impl;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.sampled.Port;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceImplTest {

    @Autowired
    @Qualifier("profileServiceImpl")
    private ProfileService profileService;
    private PortfolioService portfolioService;

    //@Test
    public void updateMyProfile() {

        ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO = new ProfileDTO.UpdateMyProfileDTO();
        updateMyProfileDTO.setUserId("user02");
        updateMyProfileDTO.setProfileImg("icecream.jpg");
        updateMyProfileDTO.setLink("www.icecream.com");
        updateMyProfileDTO.setSelfIntro("아이스크림먹고싶어");

//        ProfileDTO.GetMyProfileDTO getMyProfileDTO = profileService.getMyProfile("user01");
//        String link = "www.cyworld.net";
//        String csvLink = getMyProfileDTO.getLink()+","+link;
//        updateMyProfileDTO.setLink(csvLink);
//        System.out.println(getMyProfileDTO.getLink());

        Assert.assertEquals(1,profileService.updateMyProfile(updateMyProfileDTO));
    }

    //@Test
    public void getMyProfile() {
        ProfileDTO.GetMyProfileDTO getMyProfileDTO = new ProfileDTO.GetMyProfileDTO();

        getMyProfileDTO = profileService.getMyProfile("user04");

        Assert.assertEquals("user04", getMyProfileDTO.getUserId());
//        Assert.assertEquals("user01@test.com", getMyProfileDTO.getEmail());
//        Assert.assertEquals("choco.jpg",getMyProfileDTO.getProfileImg());
//        Assert.assertEquals("이재근",getMyProfileDTO.getName());
//        Assert.assertEquals("BRONZE",getMyProfileDTO.getGrade());
//        Assert.assertEquals(4,getMyProfileDTO.getReportCnt());
//        Assert.assertEquals("안녕안녕",getMyProfileDTO.getSelfIntro());
//        Assert.assertEquals("www.intellij.com",getMyProfileDTO.getLink());
    }

    //@Test
    public void getAdminProfile(){
        ProfileDTO.GetAdminProfileDTO getAdminProfileDTO = new ProfileDTO.GetAdminProfileDTO();

        getAdminProfileDTO = profileService.getAdminProfile("user03");

        Assert.assertEquals("user03", getAdminProfileDTO.getUserId());
//        Assert.assertEquals("user03@test.com",getAdminProfileDTO.getEmail());
//        Assert.assertEquals("김혜인",getAdminProfileDTO.getName());
//        Assert.assertEquals("ADMIN",getAdminProfileDTO.getRole());
    }

    //@Test
    public void deleteMyProfile(){
        ProfileDTO.UpdateMyProfileDTO deleteMyProfileDTO = new ProfileDTO.UpdateMyProfileDTO();
        deleteMyProfileDTO.setUserId("user02");

        Assert.assertEquals(1,profileService.updateMyProfile(deleteMyProfileDTO));
    }

    //@Test
    public void getAllProfile(){
        PortfolioVO portfolioVO = new PortfolioVO();
        portfolioVO.setUserId("user02");
        List<PortfolioVO> getAllProPort = profileService.getAllProfile(portfolioVO);
        Assert.assertEquals(3,getAllProPort.size());
    }

    //@Test
    public void getReviewList(){

//        ReviewVO reviewVO = new ReviewVO();
//
//        reviewVO.setProjectNo(2);

        List<ReviewVO> getReviewList = profileService.getReviewList(2);

        Assert.assertEquals(2, getReviewList.size());
    }

    /*@Test
    public void getBookmarkList(){
        BookmarkVO bookmarkVO = new BookmarkVO();

        bookmarkVO.setUserId("user01");

        List<BookmarkVO> getBookmarkList = profileService.getBookmarkList(bookmarkVO);

        Assert.assertEquals(2, getBookmarkList.size());
    }*/



}