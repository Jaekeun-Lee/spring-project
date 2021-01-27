package com.example.demo.config.security.service;//package com.example.demo.config.security.service;
//
//import com.example.demo.config.security.dao.UserAuthDAO;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
//public class UserServiceImpl {
//
//    @Service("userSer")
//    public class UserServiceImpl implements UserService {
//
//        @Resource(name = "userAuthDAO")
//        private UserAuthDAO userDAO;
//
//        @Override
//        public void countFailure(String username) {
//            userDAO.updateFailureCount(username);
//        }
//
//        @Override
//        public int checkFailureCount(String username) {
//            return userDAO.checkFailureCount(username);
//        }
//
//        @Override
//        public void disabledUsername(String username) {
//            userDAO.updateDisabled(username);
//        }
//    }
//}