package com.starrail.starbuddy.service;

import com.starrail.starbuddy.model.entities.Artifact;
import com.starrail.starbuddy.repo.ArtifactRepo;
import org.springframework.stereotype.Service;

@Service
public class ArtifactService {

    private final ArtifactRepo artifactRepo;

    public ArtifactService(ArtifactRepo artifactRepo) {
        this.artifactRepo = artifactRepo;
    }

    public void save(Artifact artifact) {
        artifactRepo.save(artifact);
    }

    public Artifact getArtifactById(Long id) {
        return artifactRepo.findById(id).orElse(null);
    }



}
