package com.starrail.starbuddy.service;

import com.starrail.starbuddy.model.dto.user.UserDetailsDTO;
import com.starrail.starbuddy.model.dto.user.UserLoginDTO;
import com.starrail.starbuddy.model.dto.user.UserRegisterDTO;
import com.starrail.starbuddy.model.entities.User;
import com.starrail.starbuddy.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final LoggedUser loggedUser;

    public UserService (UserRepo userRepo, LoggedUser loggedUser) {
        this.userRepo = userRepo;
        this.loggedUser = loggedUser;
    }

    public boolean register(UserRegisterDTO userRegisterDTO) {

        User user = new User();

        user
                .setUsername(userRegisterDTO.getRegisterUsername())
                .setPassword(userRegisterDTO.getRegisterPassword());

        userRepo.save(user);

        return true;
    }

    public boolean login(UserLoginDTO userLoginDTO) {

        User existingUser = userRepo.findByUsername(userLoginDTO.getUsername()).orElse(null);

        if(existingUser == null) {
            return false;
        }

        loggedUser.login(existingUser.getUsername());

        return true;
    }

    public UserDetailsDTO getLoggedUserDetails() {

        User existingUser = userRepo.findByUsername(loggedUser.getUsername()).orElse(null);

        if(existingUser == null) {
            return null;
        }

        return new UserDetailsDTO()
                .setUsername(existingUser.getUsername())
                .setArtifacts(existingUser.getArtifacts())
                .setCharacters(existingUser.getCharacters());
    }

    public User getLoggedUser() {
        return userRepo.findByUsername(loggedUser.getUsername()).orElse(null);
    }
}
