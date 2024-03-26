package com.team6.academigymraeg.controller;

import com.team6.academigymraeg.model.Test;
import com.team6.academigymraeg.repo.TestRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
    @Autowired
    private TestRepository testRepository;

   @GetMapping("/test")
    public String form(Model m){
        if (!m.containsAttribute("quiz"))
			m.addAttribute("quiz", new Test());

        return "form";
    }

    @PostMapping("/test")
    public String test(@Valid @ModelAttribute("quiz") Test quiz, Model m) {
        //currently just basically copy-pasted from camerons calc project;
        // update with what we actually need

       m.addAttribute("quiz", quiz);
       return form(m);
    }


}
