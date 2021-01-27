package com.example.demo.config.security.dao;//package com.example.demo.config.security.dao;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//public class UserAuthDAO {
//
//    @Repository
//    @RequiredArgsConstructor
//    public class UserAuthDAO {
//
//        private final SqlSession sqlSession;
//
//        public CustomUserDetails getUserById(String username) {
//            return sqlSession.selectOne("member.selectUserById", username);
//        }
//
//        public void updateFailureCount(String username) {
//            sqlSession.update("member.updateFailureCount", username);
//        }
//
//        public int checkFailureCount(String username) {
//            return sqlSession.selectOne("member.checkFailureCount", username);
//        }
//
//    }
//}
