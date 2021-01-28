package com.example.demo.project.controller;

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
@Slf4j
public class Project {

    public Project(ProjectService projectService) {
        log.info(":: "+getClass().getName()+" Start::");
        this.projectService = projectService;
    }

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    private final int PAGE_SIZE = 10;

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
        //세션 구현 후 변경
        String sessionId = "user03";

        ProjectVO projectVO = projectService.getProject(projectNo, sessionId);
        model.addAttribute("project", projectVO);

        return "project/getProject";
    }

    @GetMapping("/getProjectList")
    public String getProjectList(@RequestParam("page") int page, Model model){



        return "project/getProjectList";
    }

}
