package com.benjaminpark.smarttasktracker.model;

import com.benjaminpark.smarttasktracker.model.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Task> tasks;


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

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return Objects.equals(clientId, client.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    @Override
    public String toString() {
        return "ClientId: " + this.getClientId()
                + "\nUsername: " + this.username
                + "\nCreated At: " + this.createdAt;
    }
}
