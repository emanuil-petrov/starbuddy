package com.starrail.starbuddy.repo;

import com.starrail.starbuddy.model.CharacterNames;
import com.starrail.starbuddy.model.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Long> {

    Optional<Character> findByName(CharacterNames name);


}
