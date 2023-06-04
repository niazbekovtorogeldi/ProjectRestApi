package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.dto.studentDto.StudentRequest;
import com.example.projectrestapi.dto.studentDto.StudentRespons;

import java.util.List;

public interface StudentService {
    StudentRespons saveStudent(StudentRequest studentRequest);
    StudentRespons getStudentById(Long id);
    List<StudentRespons> getAllStudents();
    StudentRespons updateStudentById(Long id,StudentRequest studentRequest);
    SimpleRespons deleteStudentById(Long id);
    List<StudentRespons> getAllStudentByBlockerOrNotBlocked(boolean isBlocked);
    SimpleRespons blockOrUnBlock(Long id, Boolean isBlocked);

    SimpleRespons assignStudentToGroup(Long groupId,Long studentId);
}
