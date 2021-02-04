package com.example.demo.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.vo.FileVO;

public interface FileUploadService {
	
	//게시물작성/포트폴리오등록/프로젝트등록 공통적으로 사용 할 파일업로드 시스템

	void fileUpload(FileVO fileVO, String path, List<MultipartFile> fileList);

}
