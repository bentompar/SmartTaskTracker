package com.benjaminpark.smarttasktracker.model;

import com.benjaminpark.smarttasktracker.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
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

    @Column
    private LocalDateTime completedAt;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "clientId")
    private Client owner;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    private List<TaskShare> taskShares;

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
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void markAsInProgress() {
        this.status = Status.IN_PROGRESS;
    }

    public void markAsCompleted() {
        this.status = Status.COMPLETED;
        this.completedAt = LocalDateTime.now();
    }

    public Client getOwner() {
        return owner;
    }

    public List<TaskShare> getTaskShares() {
        return Collections.unmodifiableList(this.taskShares);
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
