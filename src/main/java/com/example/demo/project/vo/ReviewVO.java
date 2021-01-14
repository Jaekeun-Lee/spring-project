package com.example.demo.project.vo;

public class ReviewVO {
	
	private int reviewNo;
	private String reviewGrade;
	private String reviewComment;
	private String userId;
	
	public ReviewVO() {
		super();
	}
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(String reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", reviewGrade=" + reviewGrade + ", reviewComment=" + reviewComment
				+ ", userId=" + userId + "]";
	}

}
