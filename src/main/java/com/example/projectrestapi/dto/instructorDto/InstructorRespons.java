package com.example.projectrestapi.dto.instructorDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorRespons {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;

    public InstructorRespons(Long id, String firstName, String lastName, String phoneNumber, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
}
