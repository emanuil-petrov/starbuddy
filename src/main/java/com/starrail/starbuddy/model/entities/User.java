package com.starrail.starbuddy.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Artifact> artifacts;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Character> characters;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public User setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
        return this;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public User setCharacters(List<Character> characters) {
        this.characters = characters;
        return this;
    }
}
