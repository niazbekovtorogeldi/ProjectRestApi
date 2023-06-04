package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.courseDto.CourseRespons;
import com.example.projectrestapi.entity.Course;
import com.example.projectrestapi.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select new com.example.projectrestapi.dto.courseDto.CourseRespons(c.id,c.courseName,c.dateOfStart,c.description)from Course c")
    List<CourseRespons> getAllCourses();

    Optional<Course> getCourseById(Long id);

}
