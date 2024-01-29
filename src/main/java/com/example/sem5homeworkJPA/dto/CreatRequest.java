package com.example.sem5homeworkJPA.dto;

import com.example.sem5homeworkJPA.model.TaskStatus;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreatRequest {

    private String name;

    private String description;

    private TaskStatus status;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
