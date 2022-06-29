package com.dailycodebuffer.springboot.tutorial.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping(value="/", method = RequestMethod.GET)
    @GetMapping("/")
    public String HelloWorld(){
        return "Welcome to daily code buffer";
    }

}
