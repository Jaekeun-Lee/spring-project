package com.example.demo.project.controller;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectRest {

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    
    //세션 구현후 포스트로
    @GetMapping("/addBookmark")
    @ResponseBody
    public BookmarkVO addBookmark(@RequestParam("projectNo") int projectNo,
                                  @RequestParam("bookmarkControl") int bookmarkControl) {


        //세션구현시 세션으로
        String sessionId = "user03";
        ProjectBookmarkDTO projectBookmarkDTO = new ProjectBookmarkDTO();

        projectBookmarkDTO.setUserId(sessionId);
        projectBookmarkDTO.setProjectNo(projectNo);

        if (bookmarkControl == 1) {
            if (projectService.addBookmark(projectBookmarkDTO) == 1) {
                return projectService.getBookmark(projectBookmarkDTO);
            }
        } else if (bookmarkControl == 2) {
            projectService.deleteBookmark(projectBookmarkDTO);

        }
        return new BookmarkVO();

    }


}
