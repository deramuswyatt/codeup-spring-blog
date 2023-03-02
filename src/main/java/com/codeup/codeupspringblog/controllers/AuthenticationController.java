package com.codeup.codeupspringblog.controllers;

public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }
}
