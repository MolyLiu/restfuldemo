package com.lyk.restfuldemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class mainController {

    @RequestMapping
    public String index(){
        return "hello";
    }
}
