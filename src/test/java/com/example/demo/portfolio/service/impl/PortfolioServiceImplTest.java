package com.example.demo.portfolio.service.impl;

import com.example.demo.portfolio.service.PortfolioService;
import com.example.demo.portfolio.vo.PortfolioVO;
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

        PortfolioVO addExPort = new PortfolioVO();
        addExPort.setUserId("user02");
        addExPort.setProjectNo(1);
        addExPort.setPortProjectStartDate(new Date());
        addExPort.setPortProjectEndDate(new Date());
        addExPort.setPortDescription("테스트중");
        addExPort.setPortTitle("설명이 어설프다");
        addExPort.setPortMemberCnt(3);
//        addExPortDTO.setPortFileName("메일인증코드.docx");
//        addExPortDTO.setPortThumbnailImg("Vv.jpg");
//        addExPortDTO.setPortSkillTag(Collections.singletonList("Java"));


        Assert.assertEquals(1,portfolioService.addExPort(addExPort));

    }

    //@Test
    public void getPort() {
        PortfolioVO getPort = new PortfolioVO();

        getPort = portfolioService.getPort(12);

        Assert.assertEquals(12,getPort.getPortNo());
        Assert.assertEquals("user02",getPort.getUserId());
        Assert.assertEquals(1,getPort.getProjectNo());
        System.out.println(getPort.getPortProjectStartDate());
        System.out.println(getPort.getPortProjectEndDate());
        Assert.assertEquals(2,getPort.getPortMemberCnt());
    }

    //@Test
    public void deleteExPort() {
        PortfolioVO deleteExPort = new PortfolioVO();
        deleteExPort.setPortNo(12);

        Assert.assertEquals(1,portfolioService.deleteExPort(deleteExPort));
    }

    //@Test
    public void updateExPort(){
        PortfolioVO updateExPort = new PortfolioVO();
        updateExPort.setPortNo(13);
        updateExPort.setPortProjectStartDate(new Date());
        updateExPort.setPortProjectEndDate(new Date());
        updateExPort.setPortDescription("오늘은 규리언니가 치즈감자튀김을 자랑했다 도영이는 떡 먹고 있던데 다들 잘 먹고 다니네");
        updateExPort.setPortMemberCnt(3);
        updateExPort.setPortTitle("3조 먹성");

        Assert.assertEquals(1,portfolioService.updateExPort(updateExPort));
    }
}