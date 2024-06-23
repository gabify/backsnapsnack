package com.gabify.co.backsnapsnack.NotFoundException;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Could not find product " + id);
    }
}
