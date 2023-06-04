package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.dto.instructorDto.InstructorRequest;
import com.example.projectrestapi.dto.instructorDto.InstructorRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.entity.Company;
import com.example.projectrestapi.entity.Instructor;
import com.example.projectrestapi.repository.CompanyRepository;
import com.example.projectrestapi.repository.InstructorRepository;
import com.example.projectrestapi.service.InstrustorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl  implements InstrustorService {
    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;

    @Override
    public InstructorRespons saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return new InstructorRespons(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSpecialization(),instructor.getSpecialization());
    }

    @Override
    public InstructorRespons getInstructorById(Long id) {
        Instructor instructor = new Instructor();
        instructorRepository.getInstructorsById(id).orElseThrow(()
                -> new NullPointerException("Instructor with id " + id + "  is not found "));
        return new InstructorRespons(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSpecialization(),instructor.getSpecialization());
    }

    @Override
    public List<InstructorRespons> getAllInstructors() {
        return instructorRepository.getAllInstructors();
    }

    @Override
    public InstructorRespons updateInstructorById(Long id, InstructorRequest instructorRequest) {
        Instructor instructor =
                instructorRepository.getInstructorsById(id).orElseThrow(()
                        -> new NullPointerException("Instructor with id " + id + "  is not found "));
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return new InstructorRespons(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSpecialization(),instructor.getSpecialization());
    }

    @Override
    public SimpleRespons assignInstructorToCompany(Long companyId, Long instructorId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() ->
                        new NullPointerException("User with id " + companyId + "  is not found "));
        Instructor instructor =
                instructorRepository.getInstructorsById(instructorId).orElseThrow(()
                        -> new NullPointerException("Instructor with id " + instructorId + "  is not found "));
        company.getInstructors().add(instructor);
        companyRepository.save(company);
        instructorRepository.save(instructor);
        instructor.getCompanies().add(company);
        return new SimpleRespons(
                "assign","instructor with id "
                +instructorId+" assign to company with id "+companyId);
    }

    @Override
    public SimpleRespons deleteInstructorById(Long id) {
        boolean exist = instructorRepository.existsById(id);
        if(!exist){
            throw new NoSuchElementException("Lesson with id"+id+"is not fount");
        }
        instructorRepository.deleteById(id);
        return new SimpleRespons("deletet"+id,".");
    };

    }


