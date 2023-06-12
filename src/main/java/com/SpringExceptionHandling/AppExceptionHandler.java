package com.SpringExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> invalidData(MethodArgumentNotValidException exception){
        Map<String,String> errorData = new HashMap<>();
         exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errorData.put(error.getField(),error.getDefaultMessage()));
        return errorData;
    }
}
