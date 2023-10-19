package com.med.Cuidarmais.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HellouController {

    @GetMapping
    public String Hello(){
        return "Olá mundo String";
    }

}
