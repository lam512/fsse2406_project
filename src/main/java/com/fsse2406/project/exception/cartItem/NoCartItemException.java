package com.fsse2406.project.exception.cartItem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoCartItemException extends RuntimeException{
    public NoCartItemException (String message){
        super(message);
    }
}