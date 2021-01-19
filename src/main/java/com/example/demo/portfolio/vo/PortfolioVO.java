package com.example.demo.portfolio.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class PortfolioVO {
    private int portNo;
    private String userId;
    private int projectNo;
    private Date portProjectStartDate;  //포트포리오에 등록할 프로젝트 시작 날짜
    private Date portProjectEndDate;    //포트포리오에 등록할 프로젝트 종료 날짜
    private String portDescription;     //설명글
    private String portTitle;           //포트폴리오 제목
    private int portMemberCnt;          //프로젝트 참가 총 인원 수
//    private String portThumbnailImg;    //대표 이미지
//    private String portFileName;        //첨부파일
//    private List<String> portSkillTag;

    /**
     * 외부 포트폴리오 조회
     *
     * @param portNo
     * @param userId
     * @param projectNo
     * @param portProjectEndDate
     * @param portProjectStartDate
     * @param portDescription
     * @param portMemberCnt
     * @param portTitle
//     * @param portThumbnailImg
//     * @param portFileName
//     * @param portSkillTag
     * */

    public PortfolioVO(int portNo, String userId, int projectNo, Date portProjectStartDate, Date portProjectEndDate,
                        String portDescription, int portMemberCnt,String portTitle/*String portFileName,
                       List<String> portSkillTag, String portThumbnailImg*/) {
        this.portNo = portNo;
        this.userId = userId;
        this.projectNo = projectNo;
        this.portProjectStartDate = portProjectStartDate;
        this.portProjectEndDate = portProjectEndDate;
        this.portDescription = portDescription;
        this.portMemberCnt = portMemberCnt;
        this.portTitle = portTitle;
//        this.portThumbnailImg = portThumbnailImg;
//        this.portFileName = portFileName;
//        this.portSkillTag = portSkillTag;
    }

    /**
     * 외부 포트폴리오 등록
     *
     * @param portProjectEndDate
     * @param portProjectStartDate
     * @param portDescription
     * @param portMemberCnt
     * @param portTitle
//     * @param portThumbnailImg
//     * @param portFileName
//     * @param portSkillTag
     * */
    public PortfolioVO(Date portProjectStartDate, Date portProjectEndDate,  String portDescription,
                       int portMemberCnt,String portTitle /*String portFileName, List<String> portSkillTag,String portThumbnailImg*/) {

        this.portProjectStartDate = portProjectStartDate;
        this.portProjectEndDate = portProjectEndDate;
        this.portDescription = portDescription;
        this.portMemberCnt = portMemberCnt;
        this.portTitle = portTitle;
//        this.portThumbnailImg = portThumbnailImg;
//        this.portFileName = portFileName;
//        this.portSkillTag = portSkillTag;
    }
}
