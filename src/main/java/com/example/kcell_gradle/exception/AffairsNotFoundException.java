package com.example.kcell_gradle.exception;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
 public class AffairsNotFoundException extends RuntimeException{

     public AffairsNotFoundException(Long id){
        super("Could not find affair by this id:" + id);
    }
}
