package ru.gb.gbthymeleaf.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.api.security.dto.AuthenticationUserDto;
import ru.gb.api.security.dto.UserDto;
import ru.gb.gbthymeleaf.api.AuthApi;
import ru.gb.gbthymeleaf.api.UserApi;
import ru.gb.gbthymeleaf.utils.Cart;

import java.util.HashMap;

@Controller
@AllArgsConstructor
public class AuthController {

    private final AuthApi authApi;
    private final UserApi userApi;
    private Cart cart;

    @GetMapping("/login")
    public String authRequest(Model model){
        AuthenticationUserDto authenticationUserDto = new AuthenticationUserDto();
        model.addAttribute("authentication", authenticationUserDto);
        return "login-form";
    }

    @PostMapping("/login")
    public String authConfirm(@ModelAttribute AuthenticationUserDto authenticationUserDto){
        ResponseEntity<?> responseEntity = authApi.login(authenticationUserDto);
        HashMap<Object, Object> map = (HashMap<Object, Object>) responseEntity.getBody();
        cart.setToken((String)map.get("token"));
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
        userApi.handlePost(userDto);
        return "redirect:/login";
    }


}
