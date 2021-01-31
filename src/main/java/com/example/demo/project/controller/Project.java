package com.example.demo.project.controller;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
@Slf4j
public class Project {

    public Project(ProjectService projectService) {
        log.info(":: " + getClass().getName() + " Start::");
        this.projectService = projectService;
    }

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    private final int DEFAULT_PAGE = 1;
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
    public String getProjectList(@ModelAttribute("searchVO") SearchVO searchVO, Model model) {

        System.out.println("search" + searchVO);
        if (searchVO.getCurrentPage() == 0) {
            searchVO.setCurrentPage(DEFAULT_PAGE);
        }
        searchVO.setPageSize(PAGE_SIZE);
        searchVO.setUserId("user01");

        List<ProjectVO> projectList = projectService.getProjectList(searchVO);
        for (ProjectVO p : projectList) {
            log.info(p.toString());
        }
        model.addAttribute("projectList", projectList);

        return "project/getProjectList";

    }

}
