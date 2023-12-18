package com.starrail.starbuddy.repo;

import com.starrail.starbuddy.model.entities.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtifactRepo extends JpaRepository<Artifact, Long> {

    Optional<Artifact> findById(Long id);


}
