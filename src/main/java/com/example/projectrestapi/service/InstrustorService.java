package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.instructorDto.InstructorRequest;
import com.example.projectrestapi.dto.instructorDto.InstructorRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;

import java.util.List;

public interface InstrustorService {
    InstructorRespons saveInstructor(InstructorRequest instructorRequest);

    InstructorRespons getInstructorById(Long id);

    List<InstructorRespons> getAllInstructors();

    InstructorRespons updateInstructorById(Long id, InstructorRequest instructorRequest);

    SimpleRespons assignInstructorToCompany(Long companyId, Long instructorId);


    SimpleRespons deleteInstructorById(Long id);

}
