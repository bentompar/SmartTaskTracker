package com.benjaminpark.smarttasktracker.repository;

import com.benjaminpark.smarttasktracker.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByUsername(String username);
}
