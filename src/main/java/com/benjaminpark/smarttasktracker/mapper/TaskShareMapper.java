package com.benjaminpark.smarttasktracker.mapper;

import com.benjaminpark.smarttasktracker.dto.request.TaskShareRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskShareResponseDTO;
import com.benjaminpark.smarttasktracker.model.TaskShare;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class, ClientMapper.class})
public interface TaskShareMapper {
    TaskShare taskShareRequestDTOToTaskShare(TaskShareRequestDTO taskShareRequestDTO);
    @Mapping(source = "task.owner.clientId", target = "ownerId")
    @Mapping(source = "sharedWith.clientId", target = "sharedWithId")
    @Mapping(source = "task.taskName", target = "taskName")
    @Mapping(source = "task.taskId", target = "taskId")
    TaskShareResponseDTO taskShareToTaskShareResponseDTO(TaskShare taskShare);
    List<TaskShareResponseDTO>  taskShareToTaskShareResponseDTO(List<TaskShare> taskShares);
}
