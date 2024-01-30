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

    /**
     * Добавление задачи
     * @param task новая задач
     * @return новая задача
     */
    @PostMapping("/tasks/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Task> addNewTask(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.saveNewTask(task), HttpStatus.CREATED);
    }

    /**
     * Просмотр всех задач
     * @return Просмотр всех задач
     */
    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    /**
     * Просмотр задач по статусу
     * @param status значние для фильтрации
     * @return список задачь по выбранному параметру
     */
    @GetMapping("/tasks/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    /**
     *
     * @param id выбор задачи для изменеия статуса
     * @param status новый статус
     * @return задача с обновленным статусом
     */
    @PostMapping("/tasks/updateStatus/{id}/{status}")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    @ResponseBody
    public Task updateStatusTask(@PathVariable("id") long id, @PathVariable("status") TaskStatus status){
        return taskService.updateTaskStatus(id, status);
    }
}
