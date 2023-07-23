package com.luv2code.demo.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}