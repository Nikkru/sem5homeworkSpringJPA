package com.example.sem5homeworkJPA.service;

import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.model.TaskStatus;
import com.example.sem5homeworkJPA.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }
}
