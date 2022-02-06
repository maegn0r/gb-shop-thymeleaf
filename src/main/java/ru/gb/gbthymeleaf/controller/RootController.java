package ru.gb.gbthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping
    public String test(){
        System.out.println("in test");
        return "test";
    }
}
