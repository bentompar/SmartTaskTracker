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

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ClientResponseDTO{" + "clientId=" + clientId
                + ", username=" + username
                + ", role=" + role
                + ", createdAt=" + createdAt + '}';
    }
}
