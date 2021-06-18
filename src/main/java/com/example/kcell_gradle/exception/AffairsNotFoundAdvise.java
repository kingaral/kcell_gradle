package com.example.kcell_gradle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AffairsNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(AffairsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String affairsNotFoundHandler (AffairsNotFoundException ex){
        return ex.getMessage();
    }
}
