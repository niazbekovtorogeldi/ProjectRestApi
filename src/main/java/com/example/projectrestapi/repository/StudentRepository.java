package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.studentDto.StudentRespons;
import com.example.projectrestapi.entity.Lesson;
import com.example.projectrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select new com.example.projectrestapi.dto.studentDto.StudentRespons(s.id,s.firstName,s.lastName,s.phoneNumber,s.email,s.studyFormat,s.gender,s.isBlocked)from Student s")
    List<StudentRespons>getAllStudents();

    Optional<Student>getStudentById(Long id);
    List<StudentRespons> findStudentByIsBlocked(boolean isBlocked);
}
