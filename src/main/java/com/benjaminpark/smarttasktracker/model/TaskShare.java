package com.benjaminpark.smarttasktracker.model;

import com.benjaminpark.smarttasktracker.model.enums.ShareType;
import com.benjaminpark.smarttasktracker.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents an instance of a task being shared with another user.
 */
@Entity
@Table(name="task_shares")
public class TaskShare {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String shareId;

    @ManyToOne
    @JoinColumn(name = "taskId", referencedColumnName = "taskId")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "sharedWithId", referencedColumnName = "clientId")
    private Client sharedWith;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private ShareType shareType;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column
    private LocalDateTime completedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public TaskShare() {
        this.status=Status.PENDING;
        this.createdAt=LocalDateTime.now();
    }

    public TaskShare(Builder builder) {
        this.task = builder.task;
        this.sharedWith = builder.sharedWith;
        this.shareType = builder.shareType;
        this.status=Status.PENDING;
        this.createdAt=LocalDateTime.now();
    }

    public String getShareId() {
        return shareId;
    }

    public String getTaskId() {
        return task.getTaskId();
    }

    public String getSharedWithId() {
        return sharedWith.getClientId();
    }

    public ShareType getShareType() {
        return shareType;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Marks share as in progress.
     */
    public void markAsInProgress() {
        this.status=Status.IN_PROGRESS;
    }

    /**
     * Marks share as completed and records completion timestamp.
     * Both always set together.
     */
    public void markAsCompleted() {
        this.status=Status.COMPLETED;
        this.completedAt=LocalDateTime.now();
    }

    public static class Builder {
        private Task task;
        private Client sharedWith;
        private ShareType shareType;

        public Builder task(Task task) {
            this.task = task;
            return this;
        }

        public Builder sharedWith(Client sharedWith) {
            this.sharedWith = sharedWith;
            return this;
        }

        public Builder shareType(ShareType shareType) {
            this.shareType = shareType;
            return this;
        }

        public TaskShare build() {
            return new TaskShare(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof TaskShare)) return false;

        TaskShare that = (TaskShare) o;

        return Objects.equals(getShareId(), that.getShareId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShareId());
    }

    @Override
    public String toString() {
        return "ShareId: " + shareId
                + "\nTaskId: " + task.getTaskId()
                + "\nRecipientId: " + sharedWith.getClientId()
                + "\nShareType: " + shareType;
    }
}
