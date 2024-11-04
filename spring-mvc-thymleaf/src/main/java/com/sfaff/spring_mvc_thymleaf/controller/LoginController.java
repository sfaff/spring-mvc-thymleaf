package com.sfaff.spring_mvc_thymleaf.controller;

import com.sfaff.spring_mvc_thymleaf.model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Handle login submission
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Define the URL of the external API
//        String apiUrl = "https://external-api.com/validateUser";

        // Create a request payload
//        UserCredentials credentials = new UserCredentials(username, password);

//        ResponseEntity<Boolean> response = restTemplate.postForEntity(apiUrl, credentials, Boolean.class);

        if (Boolean.TRUE.equals(true)) {
            // Redirect to the home page if authentication is successful
            return "redirect:/home";
        } else {
            // Add error message and reload login page if authentication fails
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}
