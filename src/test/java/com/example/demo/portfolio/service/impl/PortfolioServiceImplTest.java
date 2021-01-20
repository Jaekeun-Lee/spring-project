package com.example.demo.portfolio.service.impl;

import com.example.demo.portfolio.dto.PortfolioDTO;
import com.example.demo.portfolio.service.PortfolioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.sampled.Port;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioServiceImplTest {

    @Autowired
    @Qualifier("portfolioServiceImpl")
    private PortfolioService portfolioService;

    @Test
    public void addExPort() {

        PortfolioDTO.AddExPortDTO addExPortDTO = new PortfolioDTO.AddExPortDTO();
        addExPortDTO.setUserId("user02");
        addExPortDTO.setProjectNo(1);
        addExPortDTO.setPortProjectStartDate(new Date());
        addExPortDTO.setPortProjectEndDate(new Date());
        addExPortDTO.setPortDescription("테스트중");
        addExPortDTO.setPortTitle("설명이 어설프다");
        addExPortDTO.setPortMemberCnt(3);
//        addExPortDTO.setPortFileName("메일인증코드.docx");
//        addExPortDTO.setPortThumbnailImg("Vv.jpg");
//        addExPortDTO.setPortSkillTag(Collections.singletonList("Java"));


        Assert.assertEquals(1,portfolioService.addExPort(addExPortDTO));

    }

    //@Test
   /* public void getExPort() {
        PortfolioDTO.GetExPortDTO getExPortDTO = new PortfolioDTO.GetExPortDTO();

        getExPortDTO = portfolioService.getExPort(12);

        Assert.assertEquals(12,getExPortDTO.getPortNo());
        Assert.assertEquals("user02",getExPortDTO.getUserId());
        Assert.assertEquals(1,getExPortDTO.getProjectNo());
        System.out.println(getExPortDTO.getPortProjectStartDate());
        System.out.println(getExPortDTO.getPortProjectEndDate());
        Assert.assertEquals(2,getExPortDTO.getPortMemberCnt());
    }*/

    //@Test
    public void deleteExPort() {
        PortfolioDTO.DeleteExPortDTO deleteExPortDTO = new PortfolioDTO.DeleteExPortDTO();
        deleteExPortDTO.setPortNo(12);

        Assert.assertEquals(1,portfolioService.deleteExPort(deleteExPortDTO));
    }

    //@Test
    public void updateExPort(){
        PortfolioDTO.UpdateExPortDTO updateExPortDTO = new PortfolioDTO.UpdateExPortDTO();
        updateExPortDTO.setPortNo(13);
        updateExPortDTO.setPortProjectStartDate(new Date());
        updateExPortDTO.setPortProjectEndDate(new Date());
        updateExPortDTO.setPortDescription("오늘은 규리언니가 치즈감자튀김을 자랑했다 도영이는 떡 먹고 있던데 다들 잘 먹고 다니네");
        updateExPortDTO.setPortMemberCnt(3);
        updateExPortDTO.setPortTitle("3조 먹성");

        Assert.assertEquals(1,portfolioService.updateExPort(updateExPortDTO));
    }
}