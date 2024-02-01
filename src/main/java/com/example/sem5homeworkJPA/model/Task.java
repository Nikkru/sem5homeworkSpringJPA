package com.example.sem5homeworkJPA.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Setter
    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "date_created")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime localDateTime = LocalDateTime.now();

    public Task() {
    }

}
