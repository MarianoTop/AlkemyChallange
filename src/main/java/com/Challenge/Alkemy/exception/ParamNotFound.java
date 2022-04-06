package com.Challenge.Alkemy.exception;

public class ParamNotFound extends RuntimeException{

    public ParamNotFound(String error){
        super(error);
    }
}
