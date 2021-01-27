package com.example.demo.project.controller;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/*")
public class ProjectRest {

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    @RequestMapping(value="json/addBookmark", method=RequestMethod.POST)
    public BookmarkVO addBookmark(@RequestBody ProjectBookmarkDTO projectBookmarkDTO) throws Exception {

        System.out.println("@@@@@@@@@@@@@@@"+projectBookmarkDTO);
        String sessionId = "user03";
        projectBookmarkDTO.setUserId(sessionId);

        BookmarkVO bookmark = projectService.getBookmark(projectBookmarkDTO);

        return projectService.addBookmark(projectBookmarkDTO) == 1 ? bookmark : null ;

    }

}
