package com.example.demo.projectApplicant.test;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.projectApplicant.vo.TestHashVO;

@Controller
@RequestMapping("/hash/*")
public class TestClass {
	
	@Autowired
	@Qualifier("TestService")
	private TestService testService;
	
	public TestClass() {
		System.out.println("TestClass @@@@@@@@@@");
	}
	
	@RequestMapping(value="/test")
	public String testProject() throws Exception{
		TestHashVO hash = new TestHashVO();
		hash.setHashNo(1);
		hash.setHashTag("test");
		
		testService.Test(hash);
		
		return "forward:test.jsp";
	}

}