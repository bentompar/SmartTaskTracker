package com.benjaminpark.smarttasktracker.dto.response;

import com.benjaminpark.smarttasktracker.model.enums.Role;

public class LoginResponseDTO {

    private String token;

    private Role role;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String token, Role role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" + "token=[PROTECTED], role=" + role + '}';
    }
}
