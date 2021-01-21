package com.example.demo.profile.service.impl;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.portfolio.vo.PortfolioVO;
import com.example.demo.profile.dao.ProfileDAO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    @Qualifier("profileDAOImpl")
    ProfileDAO profileDAO;

    @Override
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO) {
        return profileDAO.updateMyProfile(updateMyProfileDTO);
    }

    @Override
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId) {
        return profileDAO.getMyProfile(userId);
    }

    @Override
    public ProfileDTO.GetAdminProfileDTO getAdminProfile(String userId){
        return profileDAO.getAdminProfile(userId);
    }

    @Override
    public List<PortfolioVO> getAllProfile(PortfolioVO portfolioVO){
        return profileDAO.getAllProfile(portfolioVO);
    }

    @Override
    public int updateLink(ProfileDTO.UpdateMyProfileDTO updateLink){
        return profileDAO.updateLink(updateLink);
    }

    @Override
    public List<ReviewVO> getReviewList(ReviewVO reviewVO){
        return profileDAO.getReviewList(reviewVO);
    }

    @Override
    public List<BookmarkVO> getBookmarkList(BookmarkVO bookmarkVO){
        return profileDAO.getBookmarkList(bookmarkVO);
    }

}
