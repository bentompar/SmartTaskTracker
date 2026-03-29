package com.benjaminpark.smarttasktracker.service.impl;

import com.benjaminpark.smarttasktracker.dto.request.TaskRequestDTO;
import com.benjaminpark.smarttasktracker.dto.response.TaskResponseDTO;
import com.benjaminpark.smarttasktracker.mapper.TaskMapper;
import com.benjaminpark.smarttasktracker.model.Client;
import com.benjaminpark.smarttasktracker.model.Task;
import com.benjaminpark.smarttasktracker.model.enums.Role;
import com.benjaminpark.smarttasktracker.model.enums.Status;
import com.benjaminpark.smarttasktracker.repository.ClientRepository;
import com.benjaminpark.smarttasktracker.repository.TaskRepository;
import com.benjaminpark.smarttasktracker.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final ClientRepository clientRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(ClientRepository clientRepository, TaskRepository taskRepository, TaskMapper taskMapper) {
        this.clientRepository = clientRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional
    @Override
    public TaskResponseDTO createTask(String clientId, TaskRequestDTO taskRequestDTO) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Client client = optionalClient.orElseThrow(() -> new Exception("ClientId not found"));
        Task task = taskMapper.taskRequestDTOToTask(taskRequestDTO, client);
        try {taskRepository.save(task);}
        catch (Exception e) {
            throw new Exception("Could not save task");
        }
        TaskResponseDTO taskResponseDTO = taskMapper.taskToTaskResponseDTO(task);
        return taskResponseDTO;
    }

    @Transactional
    @Override
    public TaskResponseDTO updateTask(String clientId, Role role, String taskId, TaskRequestDTO taskRequestDTO) throws Exception {
        Optional<Task> optionalTask = taskRepository.findById(taskId);


        Task task = optionalTask.orElseThrow(() -> new Exception("Task not found"));

        if (task.getOwner().getClientId().equals(clientId) || (role.equals(Role.ROLE_ADMIN) && !task.getOwner().getRole().equals(Role.ROLE_ADMIN))) {
            taskMapper.updateTaskFromTaskRequestDTO(taskRequestDTO, task);
            try {taskRepository.save(task);}
            catch (Exception e) {
                throw new Exception("Could not save task");
            }
        } else {
            throw new Exception("Client is not authorised to update task");
        }


        TaskResponseDTO taskResponseDTO = taskMapper.taskToTaskResponseDTO(task);

        return taskResponseDTO;
    }

    @Transactional
    @Override
    public void deleteTask(String clientId, Role role, String taskId) throws Exception {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new Exception("Task not found"));

        if (task.getOwner().getClientId().equals(clientId) || (role.equals(Role.ROLE_ADMIN) && !task.getOwner().getRole().equals(Role.ROLE_ADMIN))) {
            try {taskRepository.deleteById(taskId);}
            catch (Exception e) {
                throw new Exception("Unable to delete task");
            }
        } else  {
            throw new Exception("Client is not authorised for this action");
        }

    }

    @Transactional(readOnly = true)
    @Override
    public TaskResponseDTO getTask(String clientId, Role role, String taskId) throws Exception {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new Exception("Task not found"));

        if (task.getOwner().getClientId().equals(clientId) || (role.equals(Role.ROLE_ADMIN) && !task.getOwner().getRole().equals(Role.ROLE_ADMIN))) {
            return taskMapper.taskToTaskResponseDTO(task);
        } else {
            throw new Exception("Client is not authorised for this action");
        }

    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDTO> getClientTasks(String ownerId, String requesterId, Role requesterRole) throws Exception {
        if (ownerId.equals(requesterId) || requesterRole.equals(Role.ROLE_ADMIN)) {
            List<Task> tasks = taskRepository.findByOwner(clientRepository.findById(ownerId).orElseThrow(
                    () -> new Exception("ClientId not found")));
            List<TaskResponseDTO> taskResponseDTOs = taskMapper.taskToTaskResponseDTO(tasks);
            return taskResponseDTOs;
        } else {
            throw new Exception("Client is not authorised for this action");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDTO> getAllTasksAdmin() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDTO> taskResponseDTOs = taskMapper.taskToTaskResponseDTO(tasks);
        return taskResponseDTOs;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDTO> getClientTasksByStatus(String ownerId, String requesterId, Role role, Status status) throws Exception {
        if(ownerId.equals(requesterId) || role.equals(Role.ROLE_ADMIN)) {
            List<Task> tasks = taskRepository.findByOwnerAndStatus(clientRepository.findById(ownerId).orElseThrow(
                    () -> new Exception("ClientId not found")
            ), status);
            List<TaskResponseDTO> taskResponseDTOs = taskMapper.taskToTaskResponseDTO(tasks);
            return taskResponseDTOs;
        } else {
            throw new Exception("Client is not authorised for this action");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDTO> getClientTasksDueBefore(String ownerId, String requesterId, Role role, LocalDateTime dueDateTime) throws Exception {
        if(ownerId.equals(requesterId) || role.equals(Role.ROLE_ADMIN)) {
            List<Task> tasks = taskRepository.findByOwnerAndDueDateTimeBefore(clientRepository.findById(ownerId).orElseThrow(
                    () -> new Exception("ClientId not found")
            ), dueDateTime);
            List<TaskResponseDTO> taskResponseDTOs = taskMapper.taskToTaskResponseDTO(tasks);
            return taskResponseDTOs;
        } else {
            throw new Exception("Client is not authorised for this action");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDTO> getAllTasksByStatusAdmin(Status status) {
        List<Task> tasks = taskRepository.findByStatus(status);
        List<TaskResponseDTO> taskResponseDTOs = taskMapper.taskToTaskResponseDTO(tasks);
        return taskResponseDTOs;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDTO> getAllTasksDueBeforeAdmin(LocalDateTime dueDateTime) {
        List<Task> tasks = taskRepository.findByDueDateTimeBefore(dueDateTime);
        List<TaskResponseDTO> taskResponseDTOs = taskMapper.taskToTaskResponseDTO(tasks);
        return taskResponseDTOs;
    }
}
