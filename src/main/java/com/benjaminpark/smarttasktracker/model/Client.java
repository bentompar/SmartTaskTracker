package com.benjaminpark.smarttasktracker.model;

import com.benjaminpark.smarttasktracker.model.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String clientId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Client() {
        this.role = Role.ROLE_USER;
        this.createdAt = LocalDateTime.now();
    }

    public Client(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.role = Role.ROLE_USER;
        this.createdAt = LocalDateTime.now();
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            this.password = newPassword;
        }  else {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Client build() {
            return new Client(this);
        }

    }

}
