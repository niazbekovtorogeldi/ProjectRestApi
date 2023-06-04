package com.example.projectrestapi.dto.courseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private LocalDate dateOfStart;
    private  String description;
}
