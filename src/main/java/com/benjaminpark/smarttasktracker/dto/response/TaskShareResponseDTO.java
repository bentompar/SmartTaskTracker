package com.benjaminpark.smarttasktracker.dto.response;

import com.benjaminpark.smarttasktracker.model.enums.ShareType;
import com.benjaminpark.smarttasktracker.model.enums.Status;

import java.time.LocalDateTime;

public class TaskShareResponseDTO {

    private String shareId;

    private String taskId;

    private String taskName;

    private String ownerId;

    private String sharedWithId;

    private ShareType shareType;

    private Status status;

    private LocalDateTime completedAt;

    public TaskShareResponseDTO() {}

    public TaskShareResponseDTO(String shareId, String taskId, String taskName, String ownerId, String sharedWithId, ShareType shareType, Status status, LocalDateTime completedAt) {
        this.shareId = shareId;
        this.taskId = taskId;
        this.taskName = taskName;
        this.ownerId = ownerId;
        this.sharedWithId = sharedWithId;
        this.shareType = shareType;
        this.status = status;
        this.completedAt = completedAt;
    }

    public String getShareId() {
        return shareId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getSharedWithId() {
        return sharedWithId;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    @Override
    public String toString() {
        return "TaskShareResponseDTO{" + "shareId=" + shareId
                + ", taskId=" + taskId
                + ", taskName=" + taskName
                + ", ownerId=" + ownerId
                + ", sharedWithId=" + sharedWithId
                + ", shareType=" + shareType
                + ", status=" + status
                + ", completedAt=" + (completedAt != null ? completedAt.toString() : "null") + '}';
    }
}
