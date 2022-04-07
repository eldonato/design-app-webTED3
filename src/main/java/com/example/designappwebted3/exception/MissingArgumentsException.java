package com.example.designappwebted3.exception;

public class MissingArgumentsException extends RuntimeException{

    private final String msg;

    public MissingArgumentsException(String msg){
        this.msg = msg;
    }

}
