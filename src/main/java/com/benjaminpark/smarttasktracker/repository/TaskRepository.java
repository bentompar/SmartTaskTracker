package com.benjaminpark.smarttasktracker.repository;

import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.model.Task;
import com.benjaminpark.smarttasktracker.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByStatus(Status status);
    List<Task> findByOwnerAndStatus(Client owner, Status status);
    List<Task> findByOwner(Client owner);
    List<Task> findByDueDateTimeBefore(LocalDateTime dueDateTime);
    List<Task> findByOwnerAndDueDateTimeBefore(Client owner, LocalDateTime dueDateTime);
}
