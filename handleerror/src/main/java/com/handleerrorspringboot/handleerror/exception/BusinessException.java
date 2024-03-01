package com.handleerrorspringboot.handleerror.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private String code;
    public BusinessException(String code, String message){
        super(message);
        this.code=code;
    }
}
