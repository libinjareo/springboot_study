package com.binsoft.springbootaction.springbootaction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulApiWebDemo {

    @RequestMapping("/")
    String home(){
        return "Hello World!";
    }
}
