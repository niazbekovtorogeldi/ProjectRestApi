package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.courseDto.CourseRequest;
import com.example.projectrestapi.dto.courseDto.CourseRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;

import java.util.List;

public interface CourseService {
    CourseRespons saveCourse(CourseRequest courseRequest,Long companyLongId,Long courseId);

    CourseRespons getCourseById(Long id);
    List<CourseRespons> getAllCourses();
    CourseRespons updateCourse(Long id,CourseRequest courseRequest);

    SimpleRespons deleteCourseById(Long id);
}
