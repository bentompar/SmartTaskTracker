package com.benjaminpark.smarttasktracker.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class TaskRequestDTO {

    @NotBlank(message = "Task name required")
    private String taskName;

    private String taskDescription;

    private LocalDateTime dueDateTime;

    public TaskRequestDTO() {}

    public String  getTaskName() {
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

    @Override
    public String toString() {
        return "TaskRequestDTO{" + "taskName=" + taskName
                + ", taskDescription=" + taskDescription
                + ", dueDateTime=" + dueDateTime + '}';
    }
}
