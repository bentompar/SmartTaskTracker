package com.benjaminpark.smarttasktracker.service;

import com.benjaminpark.smarttasktracker.dto.request.NotificationUpdateRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.NotificationResponseDTO;
import com.benjaminpark.smarttasktracker.model.enums.NotificationType;

import java.util.List;

public interface NotificationService {
    NotificationResponseDTO getNotification(String clientId, String notificationId);
    List<NotificationResponseDTO> getNotifications(String clientId);
    NotificationResponseDTO updateNotification(String clientId, String notificationId, NotificationUpdateRequestDTO notificationUpdateRequestDTO);
    void deleteNotification(String clientId, String notificationId);
    void createNotificationTaskShareStatusChange(String recipientId, String taskId, NotificationType notificationType, String message);
    void createNotificationTaskDeletion(String taskId);
    void createNotificationTaskUpdated(String taskId);
}
