package com.example.projectrestapi.dto.studentDto;

import com.example.projectrestapi.enam.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
@Getter
@Setter
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String studyFormat;
    private Gender gender;
    private Boolean isBlocked;
}
