package com.example.demo.member.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberVO {

    private String userId;
    private String password;
    private String name;
    private String profile_image;
    private LocalDateTime regDate;
    private LocalDateTime lastLoginDate;
}
