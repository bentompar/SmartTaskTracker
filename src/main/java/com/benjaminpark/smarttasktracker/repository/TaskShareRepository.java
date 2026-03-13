package com.benjaminpark.smarttasktracker.repository;

import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.model.TaskShare;
import com.benjaminpark.smarttasktracker.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskShareRepository extends JpaRepository<TaskShare, String> {
    List<TaskShare> findByTask_Owner(Client owner);
    List<TaskShare> findBySharedWith(Client sharedWith);
    List<TaskShare> findByStatusAndTask_Owner(Status status, Client owner);
    List<TaskShare> findByStatusAndSharedWith(Status status, Client sharedWith);
}
