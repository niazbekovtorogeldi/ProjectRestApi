package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.dto.studentDto.StudentRequest;
import com.example.projectrestapi.dto.studentDto.StudentRespons;
import com.example.projectrestapi.entity.Group;
import com.example.projectrestapi.entity.Student;
import com.example.projectrestapi.repository.GroupRepository;
import com.example.projectrestapi.repository.StudentRepository;
import com.example.projectrestapi.service.GroupService;
import com.example.projectrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public StudentRespons saveStudent(StudentRequest studentRequest) {

            Student student = new Student();
            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setEmail(studentRequest.getEmail());
            student.setGender(studentRequest.getGender());
            student.setStudyFormat(studentRequest.getStudyFormat());
            student.setIsBlocked(false);
            studentRepository.save(student);
            return new StudentRespons(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getPhoneNumber(),
                    student.getEmail(),
                    student.getStudyFormat(),
                    student.getGender(),student.getIsBlocked());
        }



        @Override
    public StudentRespons getStudentById(Long id) {
        Student student =
        studentRepository.getStudentById(id)
                .orElseThrow(() -> new NullPointerException("Lesson with id " + id + "  is not found "));
        return new StudentRespons(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getStudyFormat(),
                student.getGender(),student.getIsBlocked());

    }

    @Override
    public List<StudentRespons> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public StudentRespons updateStudentById(Long id, StudentRequest studentRequest) {
        Student student =
                studentRepository.findById(id)
                        .orElseThrow(() -> new NullPointerException("Lesson with id " + id + "  is not found "));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());
        student.setStudyFormat(studentRequest.getStudyFormat());
        studentRepository.save(student);
        return new StudentRespons(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getStudyFormat(),
                student.getGender(),student.getIsBlocked());
    }

    @Override
    public SimpleRespons deleteStudentById(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Student with id: " + id + " is not found");
        }
        studentRepository.deleteById(id);
        return new SimpleRespons("DELETED", "Student with id: " + id + " is deleted");

    }


    @Override
    public List<StudentRespons> getAllStudentByBlockerOrNotBlocked(boolean isBlocked) {
        return studentRepository.findStudentByIsBlocked(isBlocked);
    }

    @Override
    public SimpleRespons blockOrUnBlock(Long id, Boolean isBlocked) {
        try {
            Student student1 = studentRepository.findById(id)
                    .orElseThrow(() ->
                            new NullPointerException("User with id " + id + "  is not found "));
            student1.setIsBlocked(isBlocked);
            studentRepository.save(student1);
            return new SimpleRespons("Blocked", "students with " + id + "  is blocked");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return null;


    }

    @Override
    public SimpleRespons  assignStudentToGroup(Long groupId, Long studentId) {
        Group group =
                groupRepository.getGroupsById(groupId).orElseThrow(()
                        -> new NullPointerException("Group with id " + groupId + "  is not found "));
        Student student =
                studentRepository.getStudentById(studentId)
                        .orElseThrow(() -> new NullPointerException("Lesson with id " + studentId + "  is not found "));
        group.getStudents().add(student);
        groupRepository.save(group);
        student.setGroup(group);
        studentRepository.save(student);
        return new SimpleRespons(
                "assign","student with id "
                +studentId+" assign to group with id "+groupId);    }
}