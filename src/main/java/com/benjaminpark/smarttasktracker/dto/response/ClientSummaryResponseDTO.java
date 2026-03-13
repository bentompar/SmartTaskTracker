package com.benjaminpark.smarttasktracker.dto.response;

import java.util.List;

public class ClientSummaryResponseDTO {

    private String clientId;

    private String username;

    private List<TaskResponseDTO> tasks;

    public ClientSummaryResponseDTO() {}

    public ClientSummaryResponseDTO(String clientId, String username, List<TaskResponseDTO> tasks) {
        this.clientId = clientId;
        this.username = username;
        this.tasks = tasks;
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
    }

    public List<TaskResponseDTO> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "ClientSummaryResponseDTO{" + "clientId=" + clientId
                + ", username=" + username
                + ", tasks=" + (tasks != null ? tasks.toString() : "[]") + '}';
    }
}
