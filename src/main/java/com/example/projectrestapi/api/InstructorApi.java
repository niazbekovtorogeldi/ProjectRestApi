package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.companyDto.CompanyRequest;
import com.example.projectrestapi.dto.companyDto.CompanyRespons;
import com.example.projectrestapi.dto.instructorDto.InstructorRequest;
import com.example.projectrestapi.dto.instructorDto.InstructorRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.repository.InstructorRepository;
import com.example.projectrestapi.service.CompanyService;
import com.example.projectrestapi.service.InstrustorService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorApi {
    private final InstrustorService instrustorService;
    @GetMapping
    public List<InstructorRespons> getAllInstructors() {
        return instrustorService.getAllInstructors();

    }

    @PostMapping("/save")
    public InstructorRespons saveInstructors(@RequestBody InstructorRequest instructorRequest) {
        return instrustorService.saveInstructor(instructorRequest);
    }
    @GetMapping("/{id}")
    public InstructorRespons getInstructorById(@PathVariable Long id){
        return   instrustorService.getInstructorById(id);
    }
    @PutMapping("/{id}")
    public InstructorRespons  updateInstructor(@PathVariable Long id,@RequestBody InstructorRequest instructorRequest){
        return instrustorService.updateInstructorById(id,instructorRequest);

    }

    @DeleteMapping("/{id}")
    public SimpleRespons deleteInstructorById(@PathVariable Long id){
        instrustorService.deleteInstructorById(id);
        return new SimpleRespons("DELETED",  "Instructor with "+id+"  deleted");
    }

    @PostMapping("/{companyId}/{instructorId}")
    public SimpleRespons assignInstructorToCompany(@PathVariable Long companyId,@PathVariable Long instructorId) {
        instrustorService.assignInstructorToCompany(companyId,instructorId);
        return new SimpleRespons(
                "assign","instructor with id "
                +instructorId+" assign to company with id "+companyId);
    }

}
