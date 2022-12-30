package com.reactivesoftware.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class helloWorld {
    @GetMapping("/bro")
    public String sayHello(){
        return "Hello Bro";
    }
}
