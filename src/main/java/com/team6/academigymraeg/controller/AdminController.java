package com.team6.academigymraeg.controller;

import com.team6.academigymraeg.model.User;
import com.team6.academigymraeg.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    @Secured("ADMIN")
    public String admin(Model m) {
        if (!m.containsAttribute("users")) {
            m.addAttribute("users", userRepository.findAll());
        }
        if(!m.containsAttribute("roles")){
            m.addAttribute("roles", User.Role.class.getEnumConstants());
        }
        return "admin";
    }


    @RequestMapping(value = "/NewUser", method = RequestMethod.POST, params = {"name", "password"})
    public String edit(Model m, @RequestParam(value = "name", required = true) String name,
                       @RequestParam(value = "password", required = true) String password,
                       @RequestParam(value = "role", required = true) String role) {
        if (!List.of("ADMIN", "INSTRUCTOR", "USER").contains(role)) {
            // Error bad role name
            return "admin";
        }
        if (userRepository.countByUsername(name) != 0) {
            // Error for repeat username
            return "admin";
        }


        return "admin";
    }
}
