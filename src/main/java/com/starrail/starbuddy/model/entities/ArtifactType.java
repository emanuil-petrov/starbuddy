package com.starrail.starbuddy.model.entities;

import com.starrail.starbuddy.model.ArtifactTypes;
import jakarta.persistence.*;

@Entity
@Table(name = "artifact_types")
public class ArtifactType extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private ArtifactTypes artifactType;

    @Column(name = "image_reference")
    private String imageReference;

    @ManyToOne
    private ArtifactSet artifactSet;

    public ArtifactType() {

    }

    public ArtifactType(ArtifactTypes artifactType, String imageReference, ArtifactSet artifactSet) {
        this.artifactType = artifactType;
        this.imageReference = imageReference;
        this.artifactSet = artifactSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtifactTypes getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(ArtifactTypes artifactType) {
        this.artifactType = artifactType;
    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    public ArtifactSet getArtifactSet() {
        return artifactSet;
    }

    public void setArtifactSet(ArtifactSet artifactSet) {
        this.artifactSet = artifactSet;
    }
}
