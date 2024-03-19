package com.team6.academigymraeg.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    @GetMapping("/testview")
    @Secured("ADMIN")
    public String view() {
        return "testView";
    }
}
