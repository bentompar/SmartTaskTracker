package com.benjaminpark.smarttasktracker.dto.request;

import com.benjaminpark.smarttasktracker.model.enums.Status;
import jakarta.validation.constraints.NotNull;

public class TaskShareUpdateRequestDTO {

    @NotNull(message = "Task status required")
    private Status status;

    public TaskShareUpdateRequestDTO() {}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskShareUpdateRequestDTO{" + "status=" + status + '}';
    }
}
