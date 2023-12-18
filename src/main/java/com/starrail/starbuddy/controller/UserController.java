package com.starrail.starbuddy.controller;

import com.starrail.starbuddy.model.dto.user.UserLoginDTO;
import com.starrail.starbuddy.model.dto.user.UserRegisterDTO;
import com.starrail.starbuddy.service.LoggedUser;
import com.starrail.starbuddy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @PostMapping("/login")
    public ModelAndView loginProcess(@ModelAttribute("loginForm") UserLoginDTO userLoginDTO,
                                     BindingResult bindingResult) {

        userService.login(userLoginDTO);

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/register")
    public String registerProcess(@ModelAttribute("registerForm") UserRegisterDTO userRegisterDTO,
                               BindingResult bindingResult) {

        userService.register(userRegisterDTO);

        return "redirect:/";
    }

}
