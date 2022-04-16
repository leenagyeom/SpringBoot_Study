package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스는 REST API 처리하는 Controller 이다.
@RequestMapping("/api") // URI를 지정해주는 annotation
public class ApiController {

    @GetMapping("/hello")   // http://localhost:8080/api/hello
    public String hello() {
        return "Hello, leena! This is your First SpringBoot!";
    }

}