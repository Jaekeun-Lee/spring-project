package com.example.demo.project.controller;

import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.dto.ProjectSearchDTO;
import com.example.demo.project.vo.MyProjectVO;
import com.example.demo.project.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        String sessionId = "user10";

        Map map = projectService.getProject(projectNo, sessionId);
        model.addAttribute("project", map.get("projectVO"));
        model.addAttribute("existApplicant",map.get("existApplicant"));

        System.out.println("@@@@@@@@"+map.get("existApplicant"));

        return "project/getProject";
    }

    @GetMapping("/getProjectList")
    public String getProjectList(@ModelAttribute("projectSearchDTO")ProjectSearchDTO projectSearchDTO, Model model) {

        System.out.println("projectSearchDTO" + projectSearchDTO);
        if (projectSearchDTO.getCurrentPage() == 0) {
            projectSearchDTO.setCurrentPage(DEFAULT_PAGE);
        }
        projectSearchDTO.setPageSize(PAGE_SIZE);


        List<ProjectVO> projectList = projectService.getProjectList(projectSearchDTO);

        log.info(projectSearchDTO.toString());

        model.addAttribute("checkedStatus", projectSearchDTO);
        model.addAttribute("projectList", projectList);


        return "project/getProjectList";

    }

    @GetMapping("myProject")
    public String getMyProject(@RequestParam("projectNo") int projectNo, Model model) {

        if(projectNo == 0) {
            return "project/notParticipating";
        } else {
            model.addAttribute("myProject", projectService.getMyProject(projectNo));
            return "project/getMyProject";
        }

    }

}
