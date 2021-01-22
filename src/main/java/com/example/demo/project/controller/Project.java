package com.example.demo.project.controller;

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class Project {

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    @GetMapping("/template")
    public String addProject() {

        return "project/addProject";
    }

    @PostMapping("/addProject")
    public String addProject(@ModelAttribute("project")ProjectVO projectVO){
        System.out.println(projectVO);
        return "welcome";
    }

}
