package com.starrail.starbuddy;

import com.starrail.starbuddy.model.CharacterNames;
import com.starrail.starbuddy.model.entities.Artifact;
import com.starrail.starbuddy.model.entities.Character;
import com.starrail.starbuddy.service.ArtifactService;
import com.starrail.starbuddy.service.CharacterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ArtifactService artifactService;
    private final CharacterService characterService;

    public ConsoleRunner(ArtifactService artifactService, CharacterService characterService) {
        this.artifactService = artifactService;
        this.characterService = characterService;
    }

    @Override
    public void run(String... args) throws Exception {

        Character character = new Character();
        character.setName(CharacterNames.BLADE);
        character.setImageName("blade.jpg");

        characterService.save(character);


    }
}
