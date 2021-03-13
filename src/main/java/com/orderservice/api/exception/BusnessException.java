package com.orderservice.api.exception;

public class BusnessException extends RuntimeException{

    private static  final long serialVersionUID =1L;

    public BusnessException(String message){
        super(message);
    }

}
