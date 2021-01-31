package com.example.demo.project.vo;

import lombok.Data;

@Data
public class TodoVO {
	
	private int todoNo;
	private int projectNO;
	private String todoContent;
	private String userId;
	private int todoStatus;

}
