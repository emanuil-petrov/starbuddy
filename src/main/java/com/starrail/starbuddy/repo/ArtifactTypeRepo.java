package com.starrail.starbuddy.repo;

import com.starrail.starbuddy.model.ArtifactTypes;
import com.starrail.starbuddy.model.entities.ArtifactSet;
import com.starrail.starbuddy.model.entities.ArtifactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtifactTypeRepo extends JpaRepository<ArtifactType, Long> {

    Optional<ArtifactType> findByArtifactTypeAndArtifactSet(ArtifactTypes artifactTypes, ArtifactSet artifactSet);


}
