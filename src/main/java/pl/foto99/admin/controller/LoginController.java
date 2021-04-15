package pl.foto99.admin.controller;

import org.springframework.web.bind.annotation.*;
import pl.foto99.admin.config.LoginCredentials;

@RestController
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody LoginCredentials credentials) {
    }

    @GetMapping("/secured")
    public String secured() {
        return "secured";
    }
}

