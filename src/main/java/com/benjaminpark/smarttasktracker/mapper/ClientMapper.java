package com.benjaminpark.smarttasktracker.mapper;

import com.benjaminpark.smarttasktracker.dto.request.RegisterRequestDTO;
import com.benjaminpark.smarttasktracker.dto.request.UpdateClientRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.ClientResponseDTO;
import com.benjaminpark.smarttasktracker.dto.response.ClientSummaryResponseDTO;
import com.benjaminpark.smarttasktracker.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class})
public interface ClientMapper {
    Client registerRequestDTOToClient(RegisterRequestDTO registerRequestDTO);
    ClientResponseDTO clientToClientResponseDTO(Client client);
    List<ClientResponseDTO> clientToClientResponseDTO(List<Client> clients);
    ClientSummaryResponseDTO clientToClientSummaryResponseDTO(Client client);
    List<ClientSummaryResponseDTO> clientToClientSummaryResponseDTO(List<Client> clients);
    void updateClientFromUpdateClientRequestDTO(UpdateClientRequestDTO updateClientRequestDTO, @MappingTarget Client updatedClient);
}
