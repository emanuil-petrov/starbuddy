package com.starrail.starbuddy.service;

import com.starrail.starbuddy.model.ArtifactTypes;
import com.starrail.starbuddy.model.entities.ArtifactSet;
import com.starrail.starbuddy.model.entities.ArtifactType;
import com.starrail.starbuddy.repo.ArtifactTypeRepo;
import org.springframework.stereotype.Service;

@Service
public class ArtifactTypeService {
    private final ArtifactTypeRepo artifactTypeRepo;

    public ArtifactTypeService(ArtifactTypeRepo artifactTypeRepo) {
        this.artifactTypeRepo = artifactTypeRepo;
    }

    public ArtifactType findArtifactTypeByName(ArtifactTypes artifactTypes, ArtifactSet artifactSet) {
        return artifactTypeRepo.findByArtifactTypeAndArtifactSet(artifactTypes, artifactSet).orElse(null);
    }

}
