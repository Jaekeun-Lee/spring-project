package com.example.demo.project.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectReplyDTO {
    private int projectNo;
    private String replyUserId;
    private String replyContent;

}
