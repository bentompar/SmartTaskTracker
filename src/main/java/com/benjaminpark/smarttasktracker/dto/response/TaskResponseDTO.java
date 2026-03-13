package com.benjaminpark.smarttasktracker.dto.response;

import com.benjaminpark.smarttasktracker.model.enums.Status;

import java.time.LocalDateTime;

public class TaskResponseDTO {

    private String taskId;

    private String taskName;

    private String taskDescription;

    private LocalDateTime dueDateTime;

    private Status status;

    private LocalDateTime createdAt;

    private String createdBy;

    public TaskResponseDTO() {}

    public TaskResponseDTO(String taskId, String taskName, String taskDescription, LocalDateTime dueDateTime, Status status, LocalDateTime createdAt, String createdBy) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.dueDateTime = dueDateTime;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "TaskResponseDTO{" + "taskId=" + taskId
                + ", taskName=" + taskName
                + ", taskDescription=" + taskDescription
                + ", dueDateTime=" + (dueDateTime != null ? dueDateTime.toString() : "null")
                + ", status=" + status
                + ", createdAt=" + createdAt
                + ", createdBy=" + createdBy + '}';
    }
}
