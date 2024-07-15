package com.pragma.hexagonal_archetype.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static <T> ResponseEntity<T> successResponse(T body){
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
