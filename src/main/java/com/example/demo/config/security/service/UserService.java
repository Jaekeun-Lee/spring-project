package com.example.demo.config.security.service;

public interface UserService {

    void countFailure(String username);

    int checkFailureCount(String username);

    void disabledUsername(String username);

}
