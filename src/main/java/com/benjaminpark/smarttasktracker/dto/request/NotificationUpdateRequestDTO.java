package com.benjaminpark.smarttasktracker.dto.request;

public class NotificationUpdateRequestDTO {

    private boolean isRead;

    public NotificationUpdateRequestDTO() {}

    public boolean isRead() {
        return isRead;
    }
    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "NotificationUpdateRequestDTO{" + "isRead=" + isRead + '}';
    }
}
