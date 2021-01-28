package com.example.demo.project.controller;

import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@ResponseBody
@RequestMapping("/project")
public class ProjectRest {

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;


    @PostMapping("/addBookmark")
    public int addBookmark(@RequestBody ProjectBookmarkDTO projectBookmarkDTO) {


        //세션구현시 세션으로
        String sessionId = "user03";
        projectBookmarkDTO.setUserId(sessionId);

        if (projectBookmarkDTO.getBookmarkControl() == 1) {
            return projectService.addBookmark(projectBookmarkDTO);
        } else if (projectBookmarkDTO.getBookmarkControl() == 2) {
            return projectService.deleteBookmark(projectBookmarkDTO);
        } else {
            return 0;
        }
    }

    @PostMapping("/addReply")
    public ReplyVO addReply(@RequestBody ProjectReplyDTO projectReplyDTO){
        //세션구현시 세션으로
        String sessionId = "user03";
        projectReplyDTO.setReplyUserId(sessionId);

        return projectService.addProjectReply(projectReplyDTO);
    }



}
