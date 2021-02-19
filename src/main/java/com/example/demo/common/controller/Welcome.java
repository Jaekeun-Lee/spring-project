package com.example.demo.common.controller;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.service.PostService;
import com.example.demo.project.dto.ProjectSearchDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class Welcome {
	
	@Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;
	
	@Autowired
    @Qualifier("postServiceImpl")
    PostService postService;
	
	private final int DEFAULT_PAGE = 1;
    private final int PAGE_SIZE = 7;

    @GetMapping("/welcome")
    public String welcomePage(@ModelAttribute("projectSearchDTO") ProjectSearchDTO projectSearchDTO, 
    						  Model model,
    						  @ModelAttribute("searchVO") SearchVO  searchVO) {

    	// project 
        projectSearchDTO.setCurrentPage(DEFAULT_PAGE);
        projectSearchDTO.setPageSize(PAGE_SIZE);

        List<ProjectVO> projectList = projectService.getProjectList(projectSearchDTO);

        // community
        searchVO.setCurrentPage(DEFAULT_PAGE);
        searchVO.setPageSize(PAGE_SIZE);

        Map<String,Object> map = postService.getPostList(searchVO);

        model.addAttribute("postList",map.get("list"));
        model.addAttribute("projectList", projectList);

        return "welcome";
    }
}
