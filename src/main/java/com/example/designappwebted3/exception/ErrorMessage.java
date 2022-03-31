package com.example.designappwebted3.exception;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessage {

    private int statusCode;
    private Date data;
    private String message;
    private String description;
}
