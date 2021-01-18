package com.example.demo.profile.dto;

import com.example.demo.member.vo.MemberVO;
import lombok.*;

import java.util.List;

public class ProfileDTO {

    //기본정보 등록
    @Data
    public static class AddMyProfileDTO {

        private String profileImg;
        private String selfInfo;
        private List<String> link;



        /**
         * dto로 전달 받은 데이터를 기준으로 DAO에서 사용할 수 있는 VO로 변환해주는 메소드
         *
         * @return
        * */
        public MemberVO convertAddMyProfileDTOToProfileVO(){
            return new MemberVO(this.getProfileImg(), this.getSelfInfo(), this.getLink());
        }
    }

    //기본정보 조회
    @Data
    public static class GetMyProfileDTO {
        private String userId;
        private String email;
        private String name;
        private String grade;
        private String reportCnt;

        public MemberVO convertGetMyProfileDTOToProfileVO(){
            return new MemberVO(this.getUserId(), this.getName(), this.getEmail(), this.getGrade(), this.getReportCnt());
        }
    }

}
