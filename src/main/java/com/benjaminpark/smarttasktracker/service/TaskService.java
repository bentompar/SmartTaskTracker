package com.benjaminpark.smarttasktracker.service;

import com.benjaminpark.smarttasktracker.dto.request.TaskRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskResponseDTO;
import com.benjaminpark.smarttasktracker.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(String clientId, TaskRequestDTO taskRequestDTO);
    TaskResponseDTO updateTask(String clientId, String taskId, TaskRequestDTO taskRequestDTO);
    void deleteTask(String clientId, String taskId);
    TaskResponseDTO getTask(String clientId, String taskId);
    List<TaskResponseDTO> getClientTasks(String clientId);
    List<TaskResponseDTO> getAllTasksAdmin();
    List<TaskResponseDTO> getClientTasksByStatus(String clientId, Status status);
    List<TaskResponseDTO> getClientTasksDueBefore(String clientId, LocalDateTime dueDateTime);
    List<TaskResponseDTO> getAllTasksByStatusAdmin(Status status);
    List<TaskResponseDTO> getAllTasksDueBeforeAdmin(LocalDateTime dueDateTime);
}
