package com.example.springday07.Ecxeption;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }

}
