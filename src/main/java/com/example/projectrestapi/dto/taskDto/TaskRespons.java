package com.example.projectrestapi.dto.taskDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TaskRespons {
    private Long id;
    private String taskName;
    private String taskText;
    private LocalDate deadLine;

    public TaskRespons(Long id, String taskName, String taskText, LocalDate deadLine) {
        this.id = id;
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadLine = deadLine;
    }
}
