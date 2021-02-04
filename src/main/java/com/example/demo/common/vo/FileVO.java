package com.example.demo.common.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	
    private int fileNo;
    private String originFileName;
    private long fileSize;
    private int postNo;
    private int projectNo;
    private int portfolioNo;
    private String path;
      
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public int getPortfolioNo() {
		return portfolioNo;
	}
	public void setPortfolioNo(int portfolioNo) {
		this.portfolioNo = portfolioNo;
	}
	
	@Override
	public String toString() {
		return "FileVO [fileNo=" + fileNo + ", originFileName=" + originFileName + ", fileList="
				+ ", fileSize=" + fileSize + ", postNo=" + postNo + ", projectNo=" + projectNo + ", portfolioNo="
				+ portfolioNo + ", path=" + path + "]";
	}
}