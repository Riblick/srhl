package com.example.riblick.Controller;

import com.example.riblick.Entity.User;
import com.example.riblick.Repository.UserRepository;
import com.example.riblick.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/")
    public String home() {
        return "mainpage";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(User user) {

        userService.createUser(user);
        return "redirect:/login";
    }


    @GetMapping("/ab-info")
    public String abinfo() {
        return "ab-info";
    }


}
