package com.benjaminpark.smarttasktracker.mapper;

import com.benjaminpark.smarttasktracker.dto.request.TaskRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskResponseDTO;
import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "client", target = "owner")
    Task taskRequestDTOToTask(TaskRequestDTO taskRequestDTO, Client client);
    @Mapping(source = "owner.clientId", target = "createdBy")
    TaskResponseDTO taskToTaskResponseDTO(Task task);
    List<TaskResponseDTO> taskToTaskResponseDTO(List<Task> tasks);
    void updateTaskFromTaskRequestDTO(TaskRequestDTO taskRequestDTO, @MappingTarget Task updatedTask);
}
