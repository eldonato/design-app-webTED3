package com.example.designappwebted3.exception.handler;

import com.example.designappwebted3.exception.EntityNotFoundException;
import com.example.designappwebted3.exception.ErrorMessage;
import com.example.designappwebted3.exception.MissingArgumentsException;
import com.example.designappwebted3.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        var error = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(new Date())
                .build();
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request){
        ErrorMessage error = ErrorMessage.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .data(new Date())
                .description(request.getDescription(false))
                .build();
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException(EntityNotFoundException ex, WebRequest request){
        var error = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(new Date())
                .build();
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingArgumentsException.class)
    public ResponseEntity<ErrorMessage> missingArgumentsException(MissingArgumentsException ex, WebRequest request){
        var error = ErrorMessage.builder()
                .statusCode(HttpStatus.EXPECTATION_FAILED.value())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .data(new Date())
                .build();
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.EXPECTATION_FAILED);
    }

}
