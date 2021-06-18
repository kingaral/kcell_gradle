package com.example.kcell_gradle.exception;

 public class AffairsNotFoundException extends RuntimeException{

     public AffairsNotFoundException(Long id){
        super("Could not find affair by this id:" + id);
    }
}
