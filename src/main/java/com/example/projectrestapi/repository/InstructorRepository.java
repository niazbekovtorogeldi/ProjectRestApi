package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.instructorDto.InstructorRespons;
import com.example.projectrestapi.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    @Query("select new com.example.projectrestapi.dto.instructorDto.InstructorRespons(i.id,i.firstName,i.lastName,i.phoneNumber,i.specialization) from Instructor i")
    List<InstructorRespons>getAllInstructors();

    Optional<Instructor>getInstructorsById(Long id);

}
