package com.example.sem5homeworkJPA.repository;

import com.example.sem5homeworkJPA.model.Task;
import com.example.sem5homeworkJPA.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(@Param("status")TaskStatus status);
}
