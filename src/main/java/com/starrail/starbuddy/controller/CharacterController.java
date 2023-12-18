package com.starrail.starbuddy.controller;

import com.starrail.starbuddy.model.CharacterNames;
import com.starrail.starbuddy.model.entities.Character;
import com.starrail.starbuddy.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters/{name}")
    public String getCharacterPage(@PathVariable String name, Model model) {

        Character character = characterService.getCharacterByName(CharacterNames.valueOf(name.toUpperCase()));

        model.addAttribute("character", character);

        return "character";
    }




}
