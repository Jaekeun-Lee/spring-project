package com.example.demo.project.controller;

import com.example.demo.common.service.FileUploadService;
import com.example.demo.common.vo.FileVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.project.dto.AddReviewDTO;
import com.example.demo.project.service.ProjectService;
import com.example.demo.project.dto.ProjectSearchDTO;
import com.example.demo.project.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional
@Controller
@RequestMapping("/project")
@Slf4j
public class Project {

    private final String PATH = "C:\\Temp\\";

    public Project(ProjectService projectService) {
        log.info(":: " + getClass().getName() + " Start::");
        this.projectService = projectService;
    }

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;

    @Autowired
    @Qualifier("fileUploadServiceImpl")
    private FileUploadService fileUploadServiceImpl;

    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;

    private final int DEFAULT_PAGE = 1;
    private final int PAGE_SIZE = 10;

    @GetMapping("/addProject")
    public String addProject(HttpSession session) {
        MemberVO memberVO = (MemberVO)session.getAttribute("user");
        return (memberVO.getProjectNo() != 0||isWithinRange(memberVO.getProjectWithdrawalDate())) ?
                "/project/addProject" : "project/accessRestriction";

    }

    @PostMapping("/addProject")
    public String addProject(@ModelAttribute("project") ProjectVO projectVO,
                             @ModelAttribute("fileVO") FileVO fileVO,
                             MultipartHttpServletRequest request,
                             HttpSession session) {


        ProjectVO addProjectResultVO = projectService.addProject(projectVO);
        fileVO.setProjectNo(addProjectResultVO.getProjectNo());

        List<MultipartFile> fileList = request.getFiles("file");

        session.removeAttribute("user");
        MemberVO memberVO = memberService.selectMember(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        if (memberVO != null) {
            session.setAttribute("user", memberVO);
        }
        fileUploadServiceImpl.fileUpload(fileVO, PATH, fileList);
        return "welcome";

    }

    @GetMapping("/getProject")
    public String getProject(@RequestParam("projectNo") int projectNo, Model model) {

        Map<String, Object> map = projectService.getProject(projectNo, SecurityUtils.getLoginSessionMemberInfo().getUsername());
        model.addAttribute("project", map.get("projectVO"));
        model.addAttribute("existApplicant", map.get("existApplicant"));

        return "project/getProject";
    }

    @GetMapping("/getProjectList")
    public String getProjectList(@ModelAttribute("projectSearchDTO") ProjectSearchDTO projectSearchDTO, Model model) {

        System.out.println("projectSearchDTO" + projectSearchDTO);
        if (projectSearchDTO.getCurrentPage() == 0) {
            projectSearchDTO.setCurrentPage(DEFAULT_PAGE);
        }
        projectSearchDTO.setPageSize(PAGE_SIZE);


        List<ProjectVO> projectList = projectService.getProjectList(projectSearchDTO);

        log.info(projectSearchDTO.toString());

        model.addAttribute("checkedStatus", projectSearchDTO);
        model.addAttribute("projectList", projectList);


        return "project/getProjectList";

    }

    @GetMapping("/myProject")
    public String getMyProject(HttpSession session, Model model) {

        int projectNo = ((MemberVO) session.getAttribute("user")).getProjectNo();

        if (projectNo == 0) {
            return "project/notParticipating";
        } else {
            model.addAttribute("myProject", projectService.getMyProject(projectNo));
            return "project/getMyProject";
        }

    }

    @GetMapping("/addReview")
    public String addReview(HttpSession session, Model model) {

        int projectNo = ((MemberVO) session.getAttribute("user")).getProjectNo();

        if (projectNo == 0) {
            return "project/notParticipating";
        } else {
            model.addAttribute("myProject", projectService.getMyProject(projectNo));
            return "project/addReview";
        }
    }

    @PostMapping("/addReviewer")
    public String addReview(@ModelAttribute("addReviewDTO") AddReviewDTO addReviewDTO) {

        projectService.addReview(addReviewDTO);
        return "redirect:getProjectList";

    }

    private boolean isWithinRange(Date userWithdrawalDate) {

        Calendar aWeekAgo = Calendar.getInstance();
        aWeekAgo.add(Calendar.DATE , -7);
        String startDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(aWeekAgo.getTime());

        String withdrawalDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(userWithdrawalDate.getTime());

        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = date.format(today);

        LocalDate localdate = LocalDate.parse(withdrawalDate);
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        endLocalDate = endLocalDate.plusDays(1); // endDate 는 포함하지 않으므로 +1일을 해줘야함.

        return ( localdate.isBefore( startLocalDate ) ) && ( localdate.isBefore( endLocalDate ) );

    }

}
