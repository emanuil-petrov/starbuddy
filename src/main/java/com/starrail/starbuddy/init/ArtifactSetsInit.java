package com.starrail.starbuddy.init;

import com.starrail.starbuddy.model.ArtifactTypes;
import com.starrail.starbuddy.model.entities.ArtifactSet;
import com.starrail.starbuddy.model.entities.ArtifactType;
import com.starrail.starbuddy.repo.ArtifactSetRepo;
import com.starrail.starbuddy.repo.ArtifactTypeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ArtifactSetsInit implements CommandLineRunner {

    private final ArtifactSetRepo artifactSetRepo;
    private final ArtifactTypeRepo artifactTypeRepo;

    private final Integer FOUR_PIECE_SET = 4;
    private final Integer TWO_PIECE_SET = 2;

    public ArtifactSetsInit(ArtifactSetRepo artifactSetRepo, ArtifactTypeRepo artifactTypeRepo) {
        this.artifactSetRepo = artifactSetRepo;
        this.artifactTypeRepo = artifactTypeRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        long setCount = artifactSetRepo.count();

        if(setCount == 0) {
            List <ArtifactSet> artifactSetList = List.of(
                    new ArtifactSet("Band of Sizzling Thunder",         FOUR_PIECE_SET),
                    new ArtifactSet("Champion of Streetwise Boxing",    FOUR_PIECE_SET),
                    new ArtifactSet("Eagle of Twilight Line",           FOUR_PIECE_SET),
                    new ArtifactSet("Firesmith of Lava-Forging",        FOUR_PIECE_SET),
                    new ArtifactSet("Genius of Brilliant Stars",        FOUR_PIECE_SET),
                    new ArtifactSet("Guard of Wuthering Snow",          FOUR_PIECE_SET),
                    new ArtifactSet("Hunter of Glacial Forest",         FOUR_PIECE_SET),
                    new ArtifactSet("Knight of Purity Palace",          FOUR_PIECE_SET),
                    new ArtifactSet("Longevous Disciple",               FOUR_PIECE_SET),
                    new ArtifactSet("Messenger Traversing Hackerspace", FOUR_PIECE_SET),
                    new ArtifactSet("Musketeer of Wild Wheat",          FOUR_PIECE_SET),
                    new ArtifactSet("Passerby of Wandering Cloud",      FOUR_PIECE_SET),
                    new ArtifactSet("Prisoner in Deep Confinement",     FOUR_PIECE_SET),
                    new ArtifactSet("The Ashblazing Grand Duke",        FOUR_PIECE_SET),
                    new ArtifactSet("Thief of Shooting Meteor",         FOUR_PIECE_SET),
                    new ArtifactSet("Wastelander of Banditry Desert",   FOUR_PIECE_SET),
                    new ArtifactSet("Belobog of the Architects",        TWO_PIECE_SET),
                    new ArtifactSet("Broken Keel",                      TWO_PIECE_SET),
                    new ArtifactSet("Celestial Differentiator",         TWO_PIECE_SET),
                    new ArtifactSet("Firmament Frontline: Glamoth",     TWO_PIECE_SET),
                    new ArtifactSet("Fleet of the Ageless",             TWO_PIECE_SET),
                    new ArtifactSet("Inert Salsotto",                   TWO_PIECE_SET),
                    new ArtifactSet("Pan-Cosmic Commercial Enterprise", TWO_PIECE_SET),
                    new ArtifactSet("Penacony, Land of the Dreams",     TWO_PIECE_SET),
                    new ArtifactSet("Rutilant Arena",                   TWO_PIECE_SET),
                    new ArtifactSet("Space Sealing Station",            TWO_PIECE_SET),
                    new ArtifactSet("Sprightly Vonwacq",                TWO_PIECE_SET),
                    new ArtifactSet("Talia: Kingdom of Banditry",       TWO_PIECE_SET)
            );

            artifactSetRepo.saveAll(artifactSetList);
        }

        long typeCount = artifactTypeRepo.count();

        if(typeCount == 0) {

            List <ArtifactSet> artifactSetList = artifactSetRepo.findAll();

            List <ArtifactType> artifactTypeList = new ArrayList<>();

            ArtifactTypes[] artifactTypesArr = ArtifactTypes.values();

            artifactSetList.forEach(set -> {
                Long setId = set.getId();

                for(int i = 0; i < set.getArtifactsInSet(); i++) {
                    String imageReference = setId + "_" + i + ".png";

                    if (set.getArtifactsInSet() == 4) {
                        artifactTypeList.add(new ArtifactType(artifactTypesArr[i], imageReference, set));
                    }   else {
                        artifactTypeList.add(new ArtifactType(artifactTypesArr[i + 4], imageReference, set));
                    }
                }
            });

            artifactTypeRepo.saveAll(artifactTypeList);
        }

    }
}
