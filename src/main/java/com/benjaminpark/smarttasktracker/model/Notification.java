package com.benjaminpark.smarttasktracker.model;

import com.benjaminpark.smarttasktracker.model.enums.NotificationType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a notification sent to user when a shared task event occurs.
 */
@Entity
@Table(name="notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String notificationId;

    @ManyToOne
    @JoinColumn(name = "recipientId", referencedColumnName = "clientId")
    private Client recipient;

    @ManyToOne
    @JoinColumn(name = "taskId", referencedColumnName = "taskId", nullable = true)
    private Task task;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private NotificationType notificationType;

    @Column
    private String message;

    @Column(nullable=false)
    private boolean isRead;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    public Notification() {
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }

    public Notification(Builder builder) {
        this.recipient = builder.recipient;
        this.task = builder.task;
        this.notificationType = builder.notificationType;
        this.message = builder.message;
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }

    public String getNotificationId() {
        return notificationId;
    }

    public Client getRecipient() {
        return recipient;
    }

    public Task getTask() {
        return task;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        isRead = true;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private Client recipient;
        private Task task;
        private NotificationType notificationType;
        private String message;

        public Builder recipient(Client recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder task(Task task) {
            this.task = task;
            return this;
        }

        public Builder notificationType(NotificationType notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Notification)) return false;

        Notification that = (Notification) o;

        return Objects.equals(notificationId, that.notificationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId);
    }

    @Override
    public String toString() {
        return "NotificationId: " + notificationId
                + "\nRecipient: " + recipient.getUsername()
                + "\nTask: " + (task != null ? task.getTaskName() : "deleted")
                + "\nNotificationType: " + notificationType
                + "\nMessage: " + message;
    }
}
