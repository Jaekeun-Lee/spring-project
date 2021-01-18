package com.example.demo.profile.dto;

import com.example.demo.member.vo.MemberVO;
import lombok.Data;

import java.util.List;

public class ProfileDTO {

    //기본정보 등록
    @Data
    public static class UpdateMyProfileDTO {
        private String userId;
        private String profileImg;
        private String selfIntro;
        private String link;



    }

    //기본정보 조회
    @Data
    public static class GetMyProfileDTO {
        private String userId;
        private String email;
        private String name;
        private String grade;
        private String reportCnt;

        public MemberVO convertGetMyProfileDTOToMemberVO(){
            return new MemberVO(this.getUserId(), this.getName(), this.getEmail(), this.getGrade(), this.getReportCnt());
        }
    }

}
