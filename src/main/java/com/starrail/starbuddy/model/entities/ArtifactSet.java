package com.starrail.starbuddy.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sets")
public class ArtifactSet extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "artifacts_in_set")
    private int artifactsInSet;

    public ArtifactSet () {

    }

    public ArtifactSet (String name, int artifactsInSet) {
        this.name = name;
        this.artifactsInSet = artifactsInSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArtifactsInSet() {
        return artifactsInSet;
    }

    public void setArtifactsInSet(int artifactsInSet) {
        this.artifactsInSet = artifactsInSet;
    }
}
