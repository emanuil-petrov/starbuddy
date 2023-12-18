package com.starrail.starbuddy.model.dto.user;

public class UserRegisterDTO {

    private String registerUsername;

    private String registerPassword;

    private String confirmPassword;

    public String getRegisterUsername() {
        return registerUsername;
    }

    public UserRegisterDTO setRegisterUsername(String registerUsername) {
        this.registerUsername = registerUsername;
        return this;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public UserRegisterDTO setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
