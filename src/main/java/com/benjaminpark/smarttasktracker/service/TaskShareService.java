package com.benjaminpark.smarttasktracker.service;

import com.benjaminpark.smarttasktracker.dto.request.TaskShareRequestDTO;
import com.benjaminpark.smarttasktracker.dto.request.TaskShareUpdateRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskShareResponseDTO;

import java.util.List;

public interface TaskShareService {
    TaskShareResponseDTO shareTask(String clientId, String taskId, TaskShareRequestDTO taskShareRequestDTO);
    List<TaskShareResponseDTO> getAllTaskSharesAdmin();
    List<TaskShareResponseDTO> getClientTaskSharesOwner(String clientId);
    List<TaskShareResponseDTO> getClientTaskSharesRecipient(String clientId);
    TaskShareResponseDTO getTaskShare(String clientId, String shareId);
    void updateTaskShareStatus(String clientId, String shareId, TaskShareUpdateRequestDTO taskShareUpdateRequestDTO);
    void deleteTaskShare(String clientId, String shareId);
}
