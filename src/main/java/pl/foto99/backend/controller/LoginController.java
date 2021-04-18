package pl.foto99.backend.controller;

import org.springframework.web.bind.annotation.*;
import pl.foto99.backend.config.LoginCredentials;

@RestController
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {
    }

    @GetMapping("/secured")
    public String secured() {
        return "secured";
    }
}