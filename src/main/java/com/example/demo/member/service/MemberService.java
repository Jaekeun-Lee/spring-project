package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.dao.MemberDAO;
import com.example.demo.member.vo.MemberVO;
import org.springframework.http.ResponseEntity;

public interface MemberService {


    ResponseEntity<Object> loginReq(String userId, String password);

    // 해당 기능은 내부 서비스 회원만 사용하는 기능입니다.
    default boolean signUp(MemberDTO.SignUpDTO param) {
        return false;
    }

    ResponseEntity<Object> logOutReq(String userId,String password);

    default boolean withdrawal(MemberDTO.WithdrawalDTO param) {
        return false;
    }

    boolean userEmailCheck(String email, String name);
}

