package com.team6.academigymraeg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
