package com.benjaminpark.smarttasktracker.repository;

import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findByRecipient(Client recipient);
    void deleteByRecipient(Client recipient);
}
