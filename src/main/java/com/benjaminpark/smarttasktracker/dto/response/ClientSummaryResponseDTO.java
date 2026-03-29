package com.benjaminpark.smarttasktracker.dto.response;

import java.util.List;

public class ClientSummaryResponseDTO {

    private String clientId;

    private String username;

    private List<TaskResponseDTO> ownedTasks;

    private List<TaskShareResponseDTO> sharedTasks;

    public ClientSummaryResponseDTO() {}

    public ClientSummaryResponseDTO(String clientId, String username, List<TaskResponseDTO> tasks, List<TaskShareResponseDTO> taskShare) {
        this.clientId = clientId;
        this.username = username;
        this.ownedTasks = tasks;
        this.sharedTasks = taskShare;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TaskResponseDTO> getOwnedTasks() {
        return ownedTasks;
    }

    public void setOwnedTasks(List<TaskResponseDTO> ownedTasks) {
        this.ownedTasks = ownedTasks;
    }

    public List<TaskShareResponseDTO> getSharedTasks() { return sharedTasks; }

    public void setSharedTasks(List<TaskShareResponseDTO> sharedTasks) { this.sharedTasks = sharedTasks; }

    @Override
    public String toString() {
        return "ClientSummaryResponseDTO{" + "clientId=" + clientId
                + ", username=" + username
                + ", sharedTasks=" + sharedTasks
                + ", ownedTasks=" + (ownedTasks != null ? ownedTasks.toString() : "[]") + '}';
    }
}
