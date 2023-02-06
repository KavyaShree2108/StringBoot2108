package com.example.demo.service;

public class AgeDoesNotExistsException extends RuntimeException {

        public AgeDoesNotExistsException(String InvalidAge){
            super(InvalidAge);

    }
}
