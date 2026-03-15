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

    public void setShareId(String shareId) {
        this.shareId = shareId;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getSharedWithId() {
        return sharedWithId;
    }

    public void setSharedWithId(String sharedWithId) {
        this.sharedWithId = sharedWithId;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public void setShareType(ShareType shareType) {
        this.shareType = shareType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
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
