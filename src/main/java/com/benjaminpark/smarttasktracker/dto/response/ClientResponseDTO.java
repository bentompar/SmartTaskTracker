package com.benjaminpark.smarttasktracker.dto.response;

import com.benjaminpark.smarttasktracker.model.enums.Role;

import java.time.LocalDateTime;

public class ClientResponseDTO {

    private String clientId;

    private String username;

    private Role role;

    private LocalDateTime createdAt;

    public ClientResponseDTO() {}

    public ClientResponseDTO(String clientId, String username, Role role, LocalDateTime createdAt) {
        this.clientId = clientId;
        this.username = username;
        this.role = role;
        this.createdAt = createdAt;
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "ClientResponseDTO{" + "clientId=" + clientId
                + ", username=" + username
                + ", role=" + role
                + ", createdAt=" + createdAt + '}';
    }
}
