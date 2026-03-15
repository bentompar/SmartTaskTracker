package com.benjaminpark.smarttasktracker.dto.response;

import com.benjaminpark.smarttasktracker.model.enums.NotificationType;

import java.time.LocalDateTime;

public class NotificationResponseDTO {

    private String notificationId;

    private String recipientId;

    private String taskId;

    private NotificationType notificationType;

    private String message;

    private boolean isRead;

    private LocalDateTime createdAt;

    public NotificationResponseDTO() {}

    public NotificationResponseDTO(String notificationId, String recipientId, String taskId, NotificationType notificationType, String message, boolean isRead, LocalDateTime createdAt) {
        this.notificationId = notificationId;
        this.recipientId = recipientId;
        this.taskId = taskId;
        this.notificationType = notificationType;
        this.message = message;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "NotificationResponseDTO{" + "notificationId=" + notificationId
                + ", recipientId=" + recipientId
                + ", taskId=" + taskId
                + ", type=" + notificationType
                + ", message=" + message
                + ", isRead=" + isRead
                + ", createdAt=" + createdAt + '}';
    }
}
