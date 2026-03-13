package com.benjaminpark.smarttasktracker.dto.request;

import com.benjaminpark.smarttasktracker.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDTO {

    @NotBlank(message = "Username required")
    private String username;

    @NotBlank(message = "Password required")
    @ValidPassword
    private String password;

    public RegisterRequestDTO() {}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterRequestDTO{" + "username=" + username
                + ", password=[PROTECTED]}";
    }

}
