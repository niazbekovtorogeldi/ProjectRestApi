package com.example.projectrestapi.dto.studentDto;

import com.example.projectrestapi.enam.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRespons {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String studyFormat;
    private Gender gender;
    private Boolean isBlocked;

    public StudentRespons(Long id, String firstName, String lastName, String phoneNumber, String email, String studyFormat, Gender gender, Boolean isBlocked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
        this.gender = gender;
        this.isBlocked = isBlocked;
    }
}
