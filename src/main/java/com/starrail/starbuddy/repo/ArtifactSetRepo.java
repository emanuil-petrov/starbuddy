package com.starrail.starbuddy.repo;

import com.starrail.starbuddy.model.entities.ArtifactSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtifactSetRepo extends JpaRepository<ArtifactSet, Long> {

    Optional<ArtifactSet> findByName(String name);

}
