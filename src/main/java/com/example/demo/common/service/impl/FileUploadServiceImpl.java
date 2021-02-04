package com.example.demo.common.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.service.FileUploadService;
import com.example.demo.common.service.dao.FileUploadDAO;
import com.example.demo.common.vo.FileVO;

@Service("fileUploadServiceImpl")
public class FileUploadServiceImpl implements FileUploadService{
	
	@Autowired
	@Qualifier("FileUploadDAO")
	FileUploadDAO fileUploadDAO;
	public void setProjectapplicantDAO(FileUploadDAO fileUploadDAO) {
		System.out.println("::"+getClass()+".projectApplicantDAOImpl Call....");
		this.fileUploadDAO = fileUploadDAO;
	}

	@Override
	public void fileUpload(FileVO fileVO,String path, List<MultipartFile> fileList) {

		for (MultipartFile mf : fileList) {

			fileVO.setOriginFileName(mf.getOriginalFilename());
			fileVO.setFileSize(mf.getSize());

            String safeFile = path + System.currentTimeMillis() + fileVO.getOriginFileName();

            fileVO.setUploadFileName(safeFile);

            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            fileUploadDAO.uploadFile(fileVO);
        }
	}

}
