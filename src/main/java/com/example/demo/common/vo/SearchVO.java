package com.example.demo.common.vo;

public class SearchVO {
	
//	Applicant searchCondition
//	searchConditionA : 조회기간
//	searchConditionB : 신청서 상태
//		1 : 정보검토중
//		2 : 신청승인
//		3 : 거절, 참가취소
//	searchConditionC
	
	private int currentPage;
	private int searchConditionA;
	private int searchConditionB;
	private int searchConditionC;
	private String searchKeyword;
	private int pageSize;
	private int endRowNum;
	private int startRowNum;
	private int sort;
	private String userId;
	
	public SearchVO() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getSearchConditionA() {
		return searchConditionA;
	}

	public void setSearchConditionA(int searchConditionA) {
		this.searchConditionA = searchConditionA;
	}

	public int getSearchConditionB() {
		return searchConditionB;
	}

	public void setSearchConditionB(int searchConditionB) {
		this.searchConditionB = searchConditionB;
	}

	public int getSearchConditionC() {
		return searchConditionC;
	}

	public void setSearchConditionC(int searchConditionC) {
		this.searchConditionC = searchConditionC;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getEndRowNum() {
		return getCurrentPage()*getPageSize();
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getStartRowNum() {
		return (getCurrentPage()-1)*getPageSize()+1;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "SearchVO [currentPage=" + currentPage + ", searchConditionA=" + searchConditionA + ", searchConditionB="
				+ searchConditionB + ", searchConditionC=" + searchConditionC + ", searchKeyword=" + searchKeyword
				+ ", pageSize=" + pageSize + ", endRowNum=" + endRowNum + ", startRowNum=" + startRowNum + ", sort="
				+ sort + "]";
	}

}
