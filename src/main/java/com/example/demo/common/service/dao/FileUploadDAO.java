package com.example.demo.common.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.common.vo.FileVO;

import lombok.RequiredArgsConstructor;

@Repository("FileUploadDAO")
public class FileUploadDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	 }
	
	public void uploadFile(FileVO fileVO) {
		sqlSession.insert("fileuploadMapper.uploadFile",fileVO);
	}

}
