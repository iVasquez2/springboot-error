package com.springboot.error.springbooterror.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.springboot.error.springbooterror.models.Error;

@RestControllerAdvice //Mapea los lanzamientos de excepciones
public class HandlerExceptionController {

    //Error de aritmetica, en especifico division no valida
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity <Error> divisionByZero(Exception ex)
    {
        Error e = new Error();
        e.setDate(new Date());
        e.setError("Division invalida");
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(e);
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
    }

    //Recurso no encontrado/localizado
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity <Error> notFoundException (NoHandlerFoundException ex) 
    {
        Error e = new Error();
        e.setDate(new Date());
        e.setError("api REST no localizada");
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(404).body(e);
    }

    //Caracter no convertible a entero
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map <String, Object> numberFormatException (Exception ex) 
    {
        Map <String, Object> e = new HashMap<>();
        e.put("date", new Date());
        e.put("error", "Caracter no valido");
        e.put("message", ex.getMessage());
        e.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return e;
    }
}
