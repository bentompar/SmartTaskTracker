package com.benjaminpark.smarttasktracker.security;

import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientRepository clientRepository;

    public CustomUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(client);
    }

    public UserDetails loadUserByClientId(String clientId) throws UsernameNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new UsernameNotFoundException(clientId));
        return new CustomUserDetails(client);
    }
}
