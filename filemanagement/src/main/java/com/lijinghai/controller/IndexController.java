package com.lijinghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
