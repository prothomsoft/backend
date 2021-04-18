package pl.foto99.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.foto99.admin.dto.UserDto;
import pl.foto99.admin.dto.UserDtoMapper;
import pl.foto99.admin.model.User;
import pl.foto99.admin.service.UserService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserControler {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register")
    public void register(@RequestBody UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        User user = UserDtoMapper.mapToUser(userDto);
        userService.addUser(user);
    }
}
