package pl.foto99.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public void login() {
    }

    @GetMapping("/secured")
    public String secured() {
        return "secured";
    }
}