package com.example.demo.project.service.impl;

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    @Test
    void addProject() {
        projectService.addProject(new ProjectVO());
    }

    @Test
    void getProject() {

    }
}