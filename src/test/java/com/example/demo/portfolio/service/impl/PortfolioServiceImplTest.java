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

    //@Test
    public void addExPort() {

        PortfolioDTO.AddExPortDTO addExPortDTO = new PortfolioDTO.AddExPortDTO();
        addExPortDTO.setUserId("user02");
        addExPortDTO.setProjectNo(1);
        addExPortDTO.setPortProjectStartDate(new Date());
        addExPortDTO.setPortProjectEndDate(new Date());
        addExPortDTO.setPortDescription("언니가 성공하면 회원가입 시켜준댔다. 이번엔 버튼이 제대로 작동해야할텐데 허허");
        addExPortDTO.setPortTitle("효은언니 메일인증 성공기");
        addExPortDTO.setPortMemberCnt(2);
//        addExPortDTO.setPortFileName("메일인증코드.docx");
//        addExPortDTO.setPortThumbnailImg("Vv.jpg");
//        addExPortDTO.setPortSkillTag(Collections.singletonList("Java"));

        Assert.assertEquals(1,portfolioService.addExPort(addExPortDTO));

    }

    @Test
    public void getExPort() {
        PortfolioDTO.GetExPortDTO getExPortDTO = new PortfolioDTO.GetExPortDTO();

        getExPortDTO = portfolioService.getExPort(12);

        Assert.assertEquals(12,getExPortDTO.getPortNo());
        Assert.assertEquals("user02",getExPortDTO.getUserId());
        Assert.assertEquals(1,getExPortDTO.getProjectNo());
        System.out.println(getExPortDTO.getPortProjectStartDate());
        System.out.println(getExPortDTO.getPortProjectEndDate());
        Assert.assertEquals(2,getExPortDTO.getPortMemberCnt());
    }
}