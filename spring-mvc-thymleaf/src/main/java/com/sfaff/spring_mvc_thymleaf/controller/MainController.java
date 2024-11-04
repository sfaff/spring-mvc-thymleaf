package com.sfaff.spring_mvc_thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model model) {
        return "home";  // Renders the home.html template
    }

    @GetMapping("/about")
    public String about() {
        return "about";  // Create about.html for this page
    }
}

