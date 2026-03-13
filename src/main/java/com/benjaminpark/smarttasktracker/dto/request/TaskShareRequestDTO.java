package com.benjaminpark.smarttasktracker.dto.request;

import com.benjaminpark.smarttasktracker.model.enums.ShareType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskShareRequestDTO {

    @NotBlank(message = "Recipient ID required")
    private String sharedWithId;

    @NotNull(message = "Share type required")
    private ShareType shareType;

    public TaskShareRequestDTO() {}

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

    @Override
    public String toString() {
        return "TaskShareRequestDTO{" + "sharedWithId=" + sharedWithId
                + ", shareType=" + shareType + '}';
    }
}
