package com.example.demo.member.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberVO {

    private String userId;
    private String password;
    private String name;
    private LocalDateTime regDate;
    private LocalDateTime lastLoginDate;
}
