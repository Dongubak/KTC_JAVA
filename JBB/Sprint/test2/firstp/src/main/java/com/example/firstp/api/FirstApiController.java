package com.example.firstp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController {
    public FirstApiController() {
    }

    @GetMapping({"/api/hello"})
    public String hello() {
        return "hello world!";
    }
}
