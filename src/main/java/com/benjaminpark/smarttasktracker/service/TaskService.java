package com.benjaminpark.smarttasktracker.service;

import com.benjaminpark.smarttasktracker.dto.request.TaskRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskResponseDTO;
import com.benjaminpark.smarttasktracker.model.enums.Role;
import com.benjaminpark.smarttasktracker.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(String clientId, TaskRequestDTO taskRequestDTO) throws Exception;
    TaskResponseDTO updateTask(String clientId, Role role, String taskId, TaskRequestDTO taskRequestDTO) throws Exception;
    void deleteTask(String clientId, Role role, String taskId) throws Exception;
    TaskResponseDTO getTask(String clientId, Role role, String taskId) throws Exception;
    List<TaskResponseDTO> getClientTasks(String ownerId, String requesterId, Role requesterRole) throws Exception;
    List<TaskResponseDTO> getAllTasksAdmin();
    List<TaskResponseDTO> getClientTasksByStatus(String ownerId, String requesterId, Role role, Status status) throws Exception;
    List<TaskResponseDTO> getClientTasksDueBefore(String ownerId, String requesterId, Role role, LocalDateTime dueDateTime) throws Exception;
    List<TaskResponseDTO> getAllTasksByStatusAdmin(Status status);
    List<TaskResponseDTO> getAllTasksDueBeforeAdmin(LocalDateTime dueDateTime);
}
