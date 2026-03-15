package com.benjaminpark.smarttasktracker.mapper;

import com.benjaminpark.smarttasktracker.dto.request.TaskRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskResponseDTO;
import com.benjaminpark.smarttasktracker.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task taskRequestDTOToTask(TaskRequestDTO taskRequestDTO);
    @Mapping(source = "owner.clientId", target = "createdBy")
    TaskResponseDTO taskToTaskResponseDTO(Task task);
    List<TaskResponseDTO> taskToTaskResponseDTO(List<Task> tasks);
    void updateTaskFromTaskRequestDTO(TaskRequestDTO taskRequestDTO, @MappingTarget Task updatedTask);
}
