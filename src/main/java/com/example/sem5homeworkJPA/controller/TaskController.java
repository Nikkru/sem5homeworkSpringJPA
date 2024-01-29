package com.example.sem5homeworkJPA.controller;

import com.example.sem5homeworkJPA.dto.CreatRequest;
import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.repository.TaskRepository;
import com.example.sem5homeworkJPA.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping("/tasks/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Task> addNewTask(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.saveNewTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
