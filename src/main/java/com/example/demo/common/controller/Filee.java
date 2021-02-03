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

import com.example.demo.projectApplicant.service.ProjectApplicantService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/tf/*")
public class Filee {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	@RequestMapping(value = "/tt", method = RequestMethod.GET)
	public String addApplicant() throws Exception{

		return "testFile";
	}


	@RequestMapping(value = "/requestupload2")
    public String requestupload2(MultipartHttpServletRequest request) {
		int projectNo = 1;
		
        List<MultipartFile> fileList = request.getFiles("file");
        String src = request.getParameter("src");
        System.out.println("src value : " + src);

        String path = "C:\\Temp\\";

        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);

            String safeFile = path + System.currentTimeMillis() + originFileName;
            
            projectApplicantService.fileUpload(projectNo, originFileName, fileSize);
            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return "redirect:/";
    }
}
