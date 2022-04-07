package com.example.designappwebted3.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{

    private final String message;

    public EntityNotFoundException(String message){
        this.message = message;
    }
}
