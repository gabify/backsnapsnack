package com.gabify.co.backsnapsnack.ExceptionAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gabify.co.backsnapsnack.NotFoundException.ProductNotFoundException;

@RestControllerAdvice
public class ProductNotFoundAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundExceptionHandler(ProductNotFoundException e){
        return e.getMessage();
    }
}
