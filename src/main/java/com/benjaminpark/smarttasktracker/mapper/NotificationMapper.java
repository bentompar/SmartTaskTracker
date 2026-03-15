package com.benjaminpark.smarttasktracker.mapper;

import com.benjaminpark.smarttasktracker.dto.response.NotificationResponseDTO;
import com.benjaminpark.smarttasktracker.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(source = "recipient.clientId", target = "recipientId")
    @Mapping(source = "task.taskId", target = "taskId")
    NotificationResponseDTO notificationToNotificationResponseDTO(Notification notification);
    List<NotificationResponseDTO> notificationsToNotificationResponseDTOs(List<Notification> notifications);
}
