package com.benjaminpark.smarttasktracker.model;

import com.benjaminpark.smarttasktracker.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String taskId;

    @Column(nullable=false)
    private String taskName;

    @Column
    private String taskDescription;

    @Column
    private LocalDateTime dueDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "clientId")
    private Client owner;

    public Task() {
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public Task(Builder builder) {
        this.taskName = builder.taskName;
        this.taskDescription = builder.taskDescription;
        this.dueDateTime = builder.dueDateTime;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
        this.owner = builder.owner;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getDueDateTime() {
        return this.dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getOwner() {
        return this.owner;
    }



    public static class Builder {
        private String taskName;
        private String taskDescription;
        private Status status;
        private LocalDateTime dueDateTime;
        private Client owner;

        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder taskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
            return this;
        }

        public Builder dueDateTime(LocalDateTime dueDateTime) {
            this.dueDateTime = dueDateTime;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder owner(Client owner) {
            this.owner = owner;
            return this;
        }

        public Task build() {
            return new Task(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        return Objects.equals(taskId, task.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
    @Override
    public String toString() {
        return "TaskId: " + this.taskId
                + "\nTask Name: " +this.taskName
                + "\nTask Owner: " +this.owner.getUsername();
    }
}
