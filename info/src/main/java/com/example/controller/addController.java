package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addController {
    @RequestMapping("/add")
    public String ADD(){
        return "add";
    }
}
