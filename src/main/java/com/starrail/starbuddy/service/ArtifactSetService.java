package com.starrail.starbuddy.service;

import com.starrail.starbuddy.model.entities.ArtifactSet;
import com.starrail.starbuddy.repo.ArtifactSetRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtifactSetService {

    private final ArtifactSetRepo artifactSetRepo;

    public ArtifactSetService(ArtifactSetRepo artifactSetRepo) {
        this.artifactSetRepo = artifactSetRepo;
    }

    public List<String> findAllArtifactSetNames() {

        List<String> artifactSetNames = new ArrayList<>();

        artifactSetRepo.findAll().forEach(set -> {
            artifactSetNames.add(set.getName());
        });

        return artifactSetNames;
    }

    public ArtifactSet findArtifactSetByName(String name) {
        return artifactSetRepo.findByName(name).orElse(null);
    }
}
