package com.starrail.starbuddy.model.dto.user;

import com.starrail.starbuddy.model.entities.Artifact;
import com.starrail.starbuddy.model.entities.Character;

import java.util.List;

public class UserDetailsDTO {

    private String username;

    private List<Artifact> artifacts;

    private List<Character> characters;

    public String getUsername() {
        return username;
    }

    public UserDetailsDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public UserDetailsDTO setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
        return this;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public UserDetailsDTO setCharacters(List<Character> characters) {
        this.characters = characters;
        return this;
    }
}
