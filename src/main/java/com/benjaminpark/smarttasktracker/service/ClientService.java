package com.benjaminpark.smarttasktracker.service;

import com.benjaminpark.smarttasktracker.dto.request.LoginRequestDTO;
import com.benjaminpark.smarttasktracker.dto.request.RegisterRequestDTO;
import com.benjaminpark.smarttasktracker.dto.request.UpdateClientRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.ClientResponseDTO;
import com.benjaminpark.smarttasktracker.dto.response.ClientSummaryResponseDTO;
import com.benjaminpark.smarttasktracker.dto.response.LoginResponseDTO;

import java.util.List;

public interface ClientService {
    ClientResponseDTO registerClient(RegisterRequestDTO registerRequestDTO);
    ClientResponseDTO updateClient(UpdateClientRequestDTO updateClientRequestDTO, String clientId);
    LoginResponseDTO loginClient(LoginRequestDTO loginRequestDTO);
    List<ClientResponseDTO> getClients();
    List<ClientSummaryResponseDTO> getAllClientsAndTasksAdmin();
    ClientResponseDTO getClientById(String clientId);
    ClientResponseDTO getClientByUsername(String username);
    void updateClientPassword(String clientId, String oldPassword, String newPassword);
    void deleteClient(String clientId);
}
