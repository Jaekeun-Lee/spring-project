package com.example.demo.profile.dto;

import com.example.demo.common.vo.ReviewVO;
import lombok.Data;

import java.util.List;

public class ReviewDTO {

    @Data
    public static class getReviewListDTO {
        private String userId;
        private List<ReviewVO> review;
    }
}
