package com.example.demo.profile.dao;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.profile.dto.ProfileDTO;
import org.springframework.context.annotation.Profile;

import java.awt.print.Book;
import java.util.List;

public interface ProfileDAO {

    //기본정보 수정
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO);

    //기본정보 조회
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId);

    //관리자 프로필 조회
    public ProfileDTO.GetAdminProfileDTO getAdminProfile(String userId);

    //전체보기 조회
    public List<PortfolioVO> getAllProfile(PortfolioVO portfolioVO);

    //링크 등록/수정
    public int updateLink(ProfileDTO.UpdateMyProfileDTO updateLink);

    //리뷰 목록 조회
    public List<ReviewVO> getReviewList(ReviewVO reviewVO);

    //북마크 목록 조회
    public List<BookmarkVO> getBookmarkList(BookmarkVO bookmarkVO);

}
