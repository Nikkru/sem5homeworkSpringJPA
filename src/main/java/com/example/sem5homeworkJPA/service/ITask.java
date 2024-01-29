package com.example.sem5homeworkJPA.service;

import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ITask {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(long id);
    List<Task> getTasksByStatus(TaskStatus status);
    Task newTask(String name,
                 String description,
                 TaskStatus taskStatus,
                 LocalDateTime localDateTime);
    Task saveNewTask(Task task);
}
