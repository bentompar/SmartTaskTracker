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

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
