package com.Practice.Web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String WelcomeMessage(){
        return "Hello";
    }

    @RequestMapping("/about")
    public String about(){
        return "I Dont Care";
    }

}
