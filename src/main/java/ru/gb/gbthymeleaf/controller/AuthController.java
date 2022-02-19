package ru.gb.gbthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.api.security.dto.AuthenticationUserDto;
import ru.gb.api.security.dto.UserDto;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String authRequest(Model model){
        AuthenticationUserDto authenticationUserDto = new AuthenticationUserDto();
        model.addAttribute("authentication", authenticationUserDto);
        return "login-form";
    }

    @PostMapping("/login")
    public String authConfirm(@ModelAttribute AuthenticationUserDto authenticationUserDto){
        System.out.println(authenticationUserDto);
        return "redirect:/product/all";
    }

    @GetMapping("/registration")
    public String registrationRequest(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("registration", userDto);
        return "registration-form";
    }

    @PostMapping("/registration")
    public String registrationConfirm(@ModelAttribute UserDto userDto){
        System.out.println(userDto);
        return "redirect:/login";
    }


}
