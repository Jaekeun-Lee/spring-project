package com.example.demo.project.vo;

public class TodoVO {
	
	private int todoNo;
	private int projectNO;
	private String todoContent;
	private String userId;
	private int todoStatus;

	public TodoVO() {
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
		final StringBuffer sb = new StringBuffer("TodoVO{");
		sb.append("todoNo=").append(todoNo);
		sb.append(", projectNO=").append(projectNO);
		sb.append(", todoContent='").append(todoContent).append('\'');
		sb.append(", userId='").append(userId).append('\'');
		sb.append(", todoStatus=").append(todoStatus);
		sb.append('}');
		return sb.toString();
	}
}
