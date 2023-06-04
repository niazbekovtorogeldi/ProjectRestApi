package com.example.projectrestapi.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class TaskRequest {
    private String taskName;
    private String taskText;
    private LocalDate deadLine;
}
