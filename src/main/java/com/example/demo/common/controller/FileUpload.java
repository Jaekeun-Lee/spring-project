package com.example.demo.common.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.service.impl.FileUploadServiceImpl;
import com.example.demo.common.vo.FileVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;



@Controller
public class FileUpload {
	
	@Autowired
	@Qualifier("fileUploadServiceImpl")
	private FileUploadServiceImpl fileUploadServiceImpl;
	
	@RequestMapping(value = "/tt", method = RequestMethod.GET)
	public String addApplicant() throws Exception{
		//test용 html이야 127.0.0.1:8282/tt 들어가서 다중 파일 올리고 테스트 해보기 :)
		return "testFile";
	}
	
	//만약에 오류날경우에 DB에서 fileTABLE의 외래키 사용 풀고 해봐... 이게 왜 NULL이 안들어오고 0이들어올까?
	@RequestMapping(value = "/fileUpload")
	//fileVO 보면 알겠지만 안쪽에 projectNo, postNo, PortNo 전부 있으니까 활용 바람!
	//testFile.html보면 일단 임의로 projectNo설정해 뒀음
    public String requestupload2(@ModelAttribute("fileVO")FileVO fileVO,
    							 MultipartHttpServletRequest request) {
		
        List<MultipartFile> fileList = request.getFiles("file");
        
        //각자의 파일 경로 수정해주면 될거야
        String path = "C:\\Temp\\";
        System.out.println(fileVO.getPostNo());
        
        //여기서 파일 업로드 및 DB insert 해줌
        //코드 분석 외에는 이 컨트롤러 참고해서 사용하면 될거야
        fileUploadServiceImpl.fileUpload(fileVO, path, fileList);

        return "testFile2";
    }
}
