package com.example.sem5homeworkJPA.service;

import com.example.sem5homeworkJPA.exception.TaskNotFoundException;
import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.model.TaskStatus;
import com.example.sem5homeworkJPA.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService implements ITask{
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task newTask(String name, String description, TaskStatus taskStatus, LocalDateTime localDateTime){
        Task task = newTask(name, description, taskStatus, localDateTime);
        return task;
    }

    @Override
    public Task saveNewTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task updateTaskStatus(long id, TaskStatus status){
        Task updatedTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User with id %d not found", id)));
        updatedTask.setStatus(status);
        taskRepository.save(updatedTask);
        return updatedTask;
    }
}
