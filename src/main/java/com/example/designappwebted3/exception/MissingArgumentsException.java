package com.example.designappwebted3.exception;

import lombok.Getter;

@Getter
public class MissingArgumentsException extends RuntimeException{

    private final String message;

    public MissingArgumentsException(String message){
        this.message = message;
    }

}
