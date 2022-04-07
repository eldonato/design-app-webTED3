package com.example.designappwebted3.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private final String msg;

    public ResourceNotFoundException(String msg){
        this.msg = msg;
    }

}
