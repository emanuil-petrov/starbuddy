package com.starrail.starbuddy.service;

import com.starrail.starbuddy.model.ArtifactStats;
import com.starrail.starbuddy.model.entities.Artifact;
import com.starrail.starbuddy.repo.ArtifactRepo;
import com.starrail.starbuddy.util.ArtifactScorer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtifactService {

    private final ArtifactRepo artifactRepo;
    private final ArtifactScorer artifactScorer;

    public ArtifactService(ArtifactRepo artifactRepo, ArtifactScorer artifactScorer) {
        this.artifactRepo = artifactRepo;
        this.artifactScorer = artifactScorer;
    }

    public void save(Artifact artifact) {
        artifact.setArtifactScore(rateArtifact(artifact));

        artifactRepo.save(artifact);
    }


    public Artifact getArtifactById(Long id) {
        return artifactRepo.findById(id).orElse(null);
    }

    private Double rateArtifact(Artifact artifact) {
        List<Double> subStatScores = new ArrayList<>();
        double sum = 0.0;

        artifact.getSubStats().forEach((key, value) -> {
            List<Double> possibleSubStatValues = ArtifactStats.valueOf(key).getPossibleSubStatValues();
            List<Double> closestCombination = artifactScorer.findClosestCombination(value, possibleSubStatValues);

            int upgradesSize = closestCombination.size();
            double bestPossibleStats = 0d;

            for(int i = 0; i < upgradesSize; i++) {
                bestPossibleStats += possibleSubStatValues.get(2);
            }

            double score = value / bestPossibleStats;

            subStatScores.add(score);
        });

        for(double score : subStatScores) {
            sum += score;
        }

        return Double.parseDouble(String.format("%.3f", sum / subStatScores.size()));
    }

}
