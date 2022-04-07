package com.example.designappwebted3.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private final String message;

    public ResourceNotFoundException(String message){
        this.message = message;
    }

}
