package com.example.projectrestapi.dto.instructorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
@Getter
@Setter
@AllArgsConstructor
public class InstructorRequest {
    private String firstName;

    private String lastName;
    private String phoneNumber;
    private String specialization;
}
