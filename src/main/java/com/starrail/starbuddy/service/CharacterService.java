package com.starrail.starbuddy.service;

import com.starrail.starbuddy.model.CharacterNames;
import com.starrail.starbuddy.model.entities.Character;
import com.starrail.starbuddy.repo.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public Character getCharacterByName(CharacterNames name) {
        return characterRepo.findByName(name).orElse(null);
    }

    public void save(Character character) {
        characterRepo.save(character);
    }


}
