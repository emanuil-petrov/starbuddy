package com.starrail.starbuddy.model.entities;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "artifacts")
public class Artifact extends BaseEntity {

    @Column(name = "rarity")
    private int rarity;

    @Column(name = "level")
    private int level;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private ArtifactType artifactType;

    @ManyToOne
    private ArtifactSet artifactSet;

    @Column(name = "main_stat_name")
    private String mainStatName;

    @Column(name = "main_stat_value")
    private Double mainStatValue;


    @Column(name = "artifact_score")
    private Double artifactScore;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "artifact_substats", joinColumns = @JoinColumn(name = "id"))
    private Map<String, Double> subStats;

    @ManyToOne
    private User user;

    public Artifact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtifactType getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(ArtifactType artifactType) {
        this.artifactType = artifactType;
    }

    public ArtifactSet getArtifactSet() {
        return artifactSet;
    }

    public void setArtifactSet(ArtifactSet artifactSet) {
        this.artifactSet = artifactSet;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMainStatName() {
        return mainStatName;
    }

    public void setMainStatName(String mainStatName) {
        this.mainStatName = mainStatName;
    }

    public Double getMainStatValue() {
        return mainStatValue;
    }

    public void setMainStatValue(Double mainStatValue) {
        this.mainStatValue = mainStatValue;
    }

    public Double getArtifactScore() {
        return artifactScore;
    }

    public String getFormattedScore() {
        return String.valueOf(artifactScore * 100);
    }

    public void setArtifactScore(Double artifactScore) {
        this.artifactScore = artifactScore;
    }

    public Map<String, Double> getSubStats() {
        return subStats;
    }

    public void setSubStats(Map<String, Double> subStats) {
        this.subStats = subStats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
