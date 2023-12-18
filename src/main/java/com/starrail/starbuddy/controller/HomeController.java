package com.starrail.starbuddy.controller;

import com.starrail.starbuddy.model.dto.user.UserLoginDTO;
import com.starrail.starbuddy.model.dto.user.UserRegisterDTO;
import com.starrail.starbuddy.model.entities.Artifact;
import com.starrail.starbuddy.repo.ArtifactRepo;
import com.starrail.starbuddy.service.LoggedUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes({"loginForm", "registerForm"})
public class HomeController {

    private final ArtifactRepo artifactRepo;
    private final LoggedUser loggedUser;

    public HomeController(ArtifactRepo artifactRepo, LoggedUser loggedUser) {
        this.artifactRepo = artifactRepo;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("loginForm")
    public UserLoginDTO getLoginForm() {
        return new UserLoginDTO();
    }

    @ModelAttribute("registerForm")
    public UserRegisterDTO getRegisterForm() {
        return new UserRegisterDTO();
    }

    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index");
    }

}
