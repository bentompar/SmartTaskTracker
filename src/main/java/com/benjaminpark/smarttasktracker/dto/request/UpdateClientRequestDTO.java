package com.benjaminpark.smarttasktracker.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateClientRequestDTO {

    @NotBlank(message = "Username required")
    private String username;

    public UpdateClientRequestDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UpdateClientRequestDTO{" + "username=" + username + '}';
    }
}
