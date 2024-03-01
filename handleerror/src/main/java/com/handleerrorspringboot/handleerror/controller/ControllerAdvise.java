package com.handleerrorspringboot.handleerror.controller;

import com.handleerrorspringboot.handleerror.dto.ErrorDTO;
import com.handleerrorspringboot.handleerror.exception.BusinessException;
import com.handleerrorspringboot.handleerror.exception.RequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException er){
        ErrorDTO error = ErrorDTO.builder().code("P-500").message(er.getMessage()).build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException er){
        ErrorDTO error = ErrorDTO.builder().code(er.getCode()).message(er.getMessage()).build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDTO> businessExceptionHandler(BusinessException er){
        ErrorDTO error = ErrorDTO.builder().code(er.getCode()).message(er.getMessage()).build();
        return ResponseEntity.badRequest().body(error);
    }

}
