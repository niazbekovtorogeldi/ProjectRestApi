package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.lessonDto.LessonRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.dto.studentDto.StudentRequest;
import com.example.projectrestapi.dto.studentDto.StudentRespons;
import com.example.projectrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService service;


    @GetMapping
    public List<StudentRespons> getAllStudents() {
        return service.getAllStudents();

    }

    @PostMapping("/save")
    public StudentRespons saveStudent(@RequestBody StudentRequest studentRequest) {
        return service.saveStudent(studentRequest);
    }
    @GetMapping("/{id}")
    public StudentRespons getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }
    @PutMapping("/{id}")
    public StudentRespons updateStudent(@PathVariable Long id,@RequestBody StudentRequest student){
        return service.updateStudentById(id,student);

    }

    @DeleteMapping("/{id}")
    public SimpleRespons deleteStudentById(@PathVariable Long id){
        service.deleteStudentById(id);
        return  new SimpleRespons("Deleted","Student with "+id+"  deleted");
    }
    @GetMapping("/block")
    public  List<StudentRespons>getAllStudentByBlockedOrUnBlocked(@RequestParam(required = false) boolean isBlocked){
        return service.getAllStudentByBlockerOrNotBlocked(isBlocked);

    }
    @PostMapping
    public SimpleRespons blockUnOrUnBlock(
            @PathVariable Long id,
            @RequestParam (required = false)
            boolean isBlocked){
        return service.blockOrUnBlock(id,isBlocked);
    }

    @PostMapping("/{groupId}/{studentId}")
    public SimpleRespons assignStudentToGroup(@PathVariable Long groupId,@PathVariable Long studentId){
        service.assignStudentToGroup(groupId,studentId);
        return new SimpleRespons(
                "assign","student with id "
                +studentId+" assign to group with id "+groupId);    }
}