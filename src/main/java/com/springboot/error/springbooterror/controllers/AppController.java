package com.springboot.error.springbooterror.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/app") //Permite generar un directorio 
    public String index()
    {
        int x = 1/0;
        return "ok 200";
    }

}
