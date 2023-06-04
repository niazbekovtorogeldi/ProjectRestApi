package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.courseDto.CourseRequest;
import com.example.projectrestapi.dto.courseDto.CourseRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseApi {
    private final CourseService courseService;
    @GetMapping
    public List<CourseRespons> getAllCourses() {
        return courseService.getAllCourses();

    }
    @PostMapping("/save/{id}/{instructorId}")
    public CourseRespons saveCourses(@RequestBody CourseRequest courseRequest,@PathVariable Long id,@PathVariable Long instructorId) {
        return courseService.saveCourse(courseRequest,id,instructorId);
    }
    @GetMapping("/{id}")
    public CourseRespons getCoursesById(@PathVariable Long id){
        return   courseService.getCourseById(id);
    }
    @PutMapping("/{id}")
    public CourseRespons  updateCourses(@PathVariable Long id,@RequestBody CourseRequest courseRequest){
        return courseService.updateCourse(id,courseRequest);

    }
    @DeleteMapping("/{id}")
    public SimpleRespons deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return new SimpleRespons("DELETED",  "Course with "+id+"  deleted");
    }

}
