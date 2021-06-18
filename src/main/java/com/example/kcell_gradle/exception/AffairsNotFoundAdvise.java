package com.example.kcell_gradle.exception;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
* This class created for showing info when application cannot found user by id
* Also this classes to @see AffairsNotFoundException, GlobalExceptionHandler
* */
@ControllerAdvice
public class AffairsNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(AffairsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String affairsNotFoundHandler (AffairsNotFoundException ex){
        return ex.getMessage();
    }
}
