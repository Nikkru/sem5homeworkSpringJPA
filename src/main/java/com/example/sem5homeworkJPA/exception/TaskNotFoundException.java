package com.example.sem5homeworkJPA.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private long id;
    public TaskNotFoundException(long id) {
        this.id = id;
    }
}
