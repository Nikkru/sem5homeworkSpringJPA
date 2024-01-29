package com.example.sem5homeworkJPA.controller;

import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.repository.TaskRepository;
import com.example.sem5homeworkJPA.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
