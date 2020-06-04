package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/login")
    public static String login() {
        return "home/login";
    }

    @GetMapping("/logout")
    public static String logout() {
        return "home/logout";
    }
}
