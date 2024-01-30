package com.example.sem5homeworkJPA.controller;

import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.model.TaskStatus;
import com.example.sem5homeworkJPA.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/tasks/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    @PostMapping("/tasks/updateStatus/{id}/{status}")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    @ResponseBody
    public Task updateStatusTask(@PathVariable("id") long id, @PathVariable("status") TaskStatus status){
        return taskService.updateTaskStatus(id, status);
    }
}
