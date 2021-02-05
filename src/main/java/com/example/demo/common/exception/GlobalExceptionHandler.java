package com.example.demo.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<Object> RuntimeException(RuntimeException e) {
//
//        return ResponseEntity.badRequest().body()
//    }
}
