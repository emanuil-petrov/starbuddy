package com.starrail.starbuddy.model.dto.artifact;

import java.util.Map;

public class ArtifactDTO {

    private String type;

    private String artifactSet;

    private String level;

    private String rarity;

    private String mainStatName;

    private Map<String, Double> subStats;

    public String getArtifactSet() {
        return artifactSet;
    }

    public void setArtifactSet(String artifactSet) {
        this.artifactSet = artifactSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getMainStatName() {
        return mainStatName;
    }

    public void setMainStatName(String mainStatName) {
        this.mainStatName = mainStatName;
    }

    public Map<String, Double> getSubStats() {
        return subStats;
    }

    public void setSubStats(Map<String, Double> subStats) {
        this.subStats = subStats;
    }
}
