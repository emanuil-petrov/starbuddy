package com.starrail.starbuddy.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starrail.starbuddy.model.ArtifactTypes;
import com.starrail.starbuddy.model.dto.artifact.ArtifactDTO;
import com.starrail.starbuddy.model.dto.user.UserDetailsDTO;
import com.starrail.starbuddy.model.entities.Artifact;
import com.starrail.starbuddy.model.entities.ArtifactSet;
import com.starrail.starbuddy.model.entities.ArtifactType;
import com.starrail.starbuddy.model.entities.User;
import com.starrail.starbuddy.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class InventoryController {

    private final LoggedUser loggedUser;
    private final UserService userService;
    private final ArtifactSetService artifactSetService;
    private final ArtifactService artifactService;
    private final ArtifactTypeService artifactTypeService;

    public InventoryController(LoggedUser loggedUser,
                               UserService userService,
                               ArtifactSetService artifactSetService,
                               ArtifactService artifactService,
                               ArtifactTypeService artifactTypeService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.artifactSetService = artifactSetService;
        this.artifactService = artifactService;
        this.artifactTypeService = artifactTypeService;
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {

        if(!loggedUser.isLogged()) {
            return "redirect:/";
        }

        UserDetailsDTO loggedUserDetails = userService.getLoggedUserDetails();
        ArtifactDTO artifactDTO = new ArtifactDTO();

        List<String> artifactSetNames = artifactSetService.findAllArtifactSetNames();

        model.addAttribute("userDetails", loggedUserDetails);
        model.addAttribute("artifactDTO", artifactDTO);
        model.addAttribute("artifactSetNames", artifactSetNames);

        System.out.println();

        return "inventory";
    }

    @PostMapping("/add-artifact")
    public String addArtifact(@ModelAttribute("artifactDTO") ArtifactDTO artifactDTO,
                              @RequestParam("dataMap") String dataMapJson,
                              BindingResult bindingResult) {


        ArtifactSet artifactSet =
                artifactSetService.findArtifactSetByName(artifactDTO.getArtifactSet());

        ArtifactType artifactTypeByName =
                artifactTypeService.findArtifactTypeByName(ArtifactTypes.valueOf(artifactDTO.getType()), artifactSet);


        ObjectMapper objectMapper = new ObjectMapper();

        Artifact artifact = new Artifact();

        artifact.setArtifactSet(artifactSet);
        artifact.setArtifactType(artifactTypeByName);
        artifact.setLevel(Integer.parseInt(artifactDTO.getLevel()));
        artifact.setMainStatName(artifactDTO.getMainStatName());


        try {
            Map<String, Double> dataMap = objectMapper.readValue(dataMapJson, new TypeReference<>() {});

            artifact.setSubStats(dataMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = userService.getLoggedUser();

        artifact.setUser(user);

        System.out.println();

        artifactService.save(artifact);

        return "redirect:/";
    }
}
