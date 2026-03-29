package com.benjaminpark.smarttasktracker.service.impl;

import com.benjaminpark.smarttasktracker.dto.request.LoginRequestDTO;
import com.benjaminpark.smarttasktracker.dto.request.RegisterRequestDTO;
import com.benjaminpark.smarttasktracker.dto.request.UpdateClientRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.ClientResponseDTO;
import com.benjaminpark.smarttasktracker.dto.response.ClientSummaryResponseDTO;
import com.benjaminpark.smarttasktracker.dto.response.LoginResponseDTO;
import com.benjaminpark.smarttasktracker.mapper.*;
import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.model.enums.Role;
import com.benjaminpark.smarttasktracker.repository.ClientRepository;
import com.benjaminpark.smarttasktracker.security.CustomUserDetails;
import com.benjaminpark.smarttasktracker.security.JwtUtil;
import com.benjaminpark.smarttasktracker.service.ClientService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientMapper clientMapper,
                             AuthenticationManager authenticationManager,
                             JwtUtil jwtUtil,
                             PasswordEncoder passwordEncoder) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public ClientResponseDTO registerClient(RegisterRequestDTO registerRequestDTO) throws DataIntegrityViolationException {
        String hashedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());
        Client client = clientMapper.registerRequestDTOToClient(registerRequestDTO, hashedPassword);
        try {client = clientRepository.save(client);}
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Username already exists");
        }

        ClientResponseDTO clientResponseDTO = clientMapper.clientToClientResponseDTO(client);

        return clientResponseDTO;
    }

    @Transactional
    @Override
    public ClientResponseDTO updateClient(UpdateClientRequestDTO updateClientRequestDTO, String clientId) throws Exception {
        Optional<Client> originalClient = clientRepository.findById(clientId);
        Client client = originalClient.orElseThrow(() -> new Exception("Client not found"));
        clientMapper.updateClientFromUpdateClientRequestDTO(updateClientRequestDTO, client);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.clientToClientResponseDTO(updatedClient);
    }

    @Override
    public LoginResponseDTO loginClient(LoginRequestDTO loginRequestDTO) throws Exception {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();


        String tokenString = jwtUtil.generateJwtToken(userDetails.getClientId());
        Role role = userDetails.getRole();

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(tokenString);
        loginResponseDTO.setRole(role);

        return loginResponseDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientResponseDTO> getClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> clientResponseDTOs = new ArrayList<>();
        for (Client client : clients) {
            ClientResponseDTO clientResponseDTO = clientMapper.clientToClientResponseDTO(client);
            clientResponseDTOs.add(clientResponseDTO);
        }
        return Collections.unmodifiableList(clientResponseDTOs);

    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientSummaryResponseDTO> getAllClientsAndTasksAdmin() {
        List<ClientSummaryResponseDTO> clientResponseDTOs = new ArrayList<>();
        List<Client> clients = clientRepository.findAll();

        for (Client client : clients) {
            ClientSummaryResponseDTO clientResponseDTO = clientMapper.clientToClientSummaryResponseDTO(client);
            clientResponseDTOs.add(clientResponseDTO);
        }

        return Collections.unmodifiableList(clientResponseDTOs);
    }

    @Transactional(readOnly = true)
    @Override
    public ClientResponseDTO getClientById(String clientId) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Client client = optionalClient.orElseThrow(() -> new Exception("ClientId not found"));
        return clientMapper.clientToClientResponseDTO(client);
    }

    @Transactional(readOnly = true)
    @Override
    public ClientResponseDTO getClientByUsername(String username) {
        Client client = clientRepository.findByUsername(username);
        if (client != null) {
            return clientMapper.clientToClientResponseDTO(client);
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    @Transactional
    @Override
    public void updateClientPassword(String clientId, String oldPassword, String newPassword) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Client client = optionalClient.orElseThrow(() -> new Exception("ClientId not found"));
        if (passwordEncoder.matches(oldPassword, client.getPassword())) {
            client.updatePassword(passwordEncoder.encode(newPassword));
            clientRepository.save(client);
        } else {
            throw new Exception("Old password does not match");
        }
    }

    @Transactional
    @Override
    public void deleteClient(String clientId) {
        clientRepository.deleteById(clientId);
    }
}
