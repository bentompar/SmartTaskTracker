package com.benjaminpark.smarttasktracker.dto.response;

import com.benjaminpark.smarttasktracker.model.enums.NotificationType;

import java.time.LocalDateTime;

public class NotificationResponseDTO {

    private String notificationId;

    private String recipientId;

    private String taskId;

    private NotificationType type;

    private String message;

    private boolean isRead;

    private LocalDateTime createdAt;

    public NotificationResponseDTO() {}

    public NotificationResponseDTO(String notificationId, String recipientId, String taskId, NotificationType type, String message, boolean isRead, LocalDateTime createdAt) {
        this.notificationId = notificationId;
        this.recipientId = recipientId;
        this.taskId = taskId;
        this.type = type;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public String getTaskId() {
        return taskId;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "NotificationResponseDTO{" + "notificationId=" + notificationId
                + ", recipientId=" + recipientId
                + ", taskId=" + taskId
                + ", type=" + type
                + ", message=" + message
                + ", isRead=" + isRead
                + ", createdAt=" + createdAt + '}';
    }
}
