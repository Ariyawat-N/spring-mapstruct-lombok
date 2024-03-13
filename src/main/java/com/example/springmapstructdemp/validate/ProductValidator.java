package com.example.springmapstructdemp.validate;

import org.springframework.stereotype.Component;

@Component
public class ProductValidator {

    public int validate(int id) throws ProductValidationException{
        if(id==-1){
            throw new ProductValidationException("Invalid id value");
        }
        return id;
    }
}
