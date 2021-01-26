package com.example.demo.project.controller;

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addProject(@ModelAttribute("project") ProjectVO projectVO) {
        System.out.println(projectVO);
        return "welcome";
    }

    @GetMapping("/getProject")
    public String getProject(@RequestParam("projectNo") int projectNo, Model model) {
        String sessionId = "user01";

        model.addAttribute("project", projectService.getProject(projectNo, sessionId));

        return "project/getProject";
    }

}
