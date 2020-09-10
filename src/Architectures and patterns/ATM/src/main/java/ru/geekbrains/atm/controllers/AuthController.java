package ru.geekbrains.atm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.geekbrains.atm.entities.AuthData;
import ru.geekbrains.atm.services.AuthService;

@Controller
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public String authorize(@ModelAttribute AuthData authData){
        return authService.authorize(authData);
    }

}
