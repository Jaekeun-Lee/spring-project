package com.example.demo.member.service.impl;


import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.dao.MemberDAO;
import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberDAO memberDAO;

    @Override
    public ResponseEntity<Object> loginReq(String id, String password) {
        // id가 존재하지 않는 경우
        if (false) {
            return ResponseEntity.badRequest().body("아이디가 존재하지 않습니다.");
        }

        // password fail
        if (false) {
            return ResponseEntity.badRequest().body("비밀번호가 틀렸습니다.");
        }

        return ResponseEntity.ok().body("로그인 성공");
    }

    //회원가입
    @Override
    @Transactional
    public boolean signUp(MemberDTO.SignUpDTO signUpDTO) {
        int dbResult = memberDAO.addMember(signUpDTO.convertSignUpDTOToMemberVO());
        if (dbResult != 1) { // transaction rollback을 위해서 의도적으로 예외처리를 함.
            throw new RuntimeException();
        }

        return true;
    }

}

