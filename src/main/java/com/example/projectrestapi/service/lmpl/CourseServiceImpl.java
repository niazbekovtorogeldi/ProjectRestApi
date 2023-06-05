package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.dto.courseDto.CourseRequest;
import com.example.projectrestapi.dto.courseDto.CourseRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.entity.Company;
import com.example.projectrestapi.entity.Course;
import com.example.projectrestapi.entity.Instructor;
import com.example.projectrestapi.repository.CompanyRepository;
import com.example.projectrestapi.repository.CourseRepository;
import com.example.projectrestapi.repository.InstructorRepository;
import com.example.projectrestapi.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final InstructorRepository instructorRepository;

    @Override
    public CourseRespons saveCourse(CourseRequest courseRequest, Long companyId,Long courseId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        Instructor instructor=instructorRepository.getInstructorsById(courseId).orElseThrow(()->new NoSuchElementException("instructor not found"));
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDescription(courseRequest.getDescription());
        course.setDateOfStart(LocalDate.now());
        course.setCompanies(company);
        course.setInstructors(instructor);
        courseRepository.save(course);
        company.getCourses().add(course);
        instructor.getCourses().add(course);
        return new CourseRespons(
                course.getId(),
                course.getCourseName(),course.getDateOfStart(),course.getDescription());

    }

    @Override
    public CourseRespons getCourseById(Long id) {
        Course course  =
        courseRepository.getCourseById(id).orElseThrow(()->new NullPointerException("Company with id:"+id+"is not found"));
        return new CourseRespons(course.getId(),course.getCourseName(),course.getDateOfStart(),course.getDescription());
    }

    @Override
    public List<CourseRespons> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public CourseRespons updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).orElseThrow(()->new NullPointerException(id+"is not fount"));
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);
        return new CourseRespons(course.getId(),course.getCourseName(),course.getDateOfStart(),course.getDescription());
    }

    @Override
    public SimpleRespons deleteCourseById(Long id) {
        boolean exist = courseRepository.existsById(id);
        if(!exist){
            throw new NoSuchElementException("Course with id:"+id+"is not fount");

        }
        companyRepository.deleteById(id);
        return new SimpleRespons("deletet"+id,".");

    }
}
