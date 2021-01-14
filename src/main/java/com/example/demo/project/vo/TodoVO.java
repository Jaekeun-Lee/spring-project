package com.example.demo.project.vo;

public class TodoVO {
	
	private int todoNo;
	private int projectNO;
	private String todoContent;
	private String userId;
	private int todoStatus;
	
	public TodoVO() {
		super();
	}
	public int getTodoNo() {
		return todoNo;
	}
	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}
	public int getProjectNO() {
		return projectNO;
	}
	public void setProjectNO(int projectNO) {
		this.projectNO = projectNO;
	}
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTodoStatus() {
		return todoStatus;
	}
	public void setTodoStatus(int todoStatus) {
		this.todoStatus = todoStatus;
	}
	
	@Override
	public String toString() {
		return "TodoVO [todoNo=" + todoNo + ", projectNO=" + projectNO + ", todoContent=" + todoContent + ", userId="
				+ userId + ", todoStatus=" + todoStatus + "]";
	}
	
}
