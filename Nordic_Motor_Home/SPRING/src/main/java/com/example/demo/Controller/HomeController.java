package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/login")
    public static String login() {
        return "home/login";
    }

    @GetMapping("/logout")
    public static String logout() {
        return "login";
    }
}
