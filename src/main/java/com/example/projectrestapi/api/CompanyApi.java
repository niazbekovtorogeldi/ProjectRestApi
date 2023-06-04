package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.companyDto.CompanyGetAllInfoStudent;
import com.example.projectrestapi.dto.companyDto.CompanyGetAllInformationResponse;
import com.example.projectrestapi.dto.companyDto.CompanyRequest;
import com.example.projectrestapi.dto.companyDto.CompanyRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.entity.Company;
import com.example.projectrestapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;
    @GetMapping
    public List<CompanyRespons> getAllCompanies(){
        return companyService.getAllCompanies();
    }
    @PostMapping("/save")
    public CompanyRespons saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }
    @GetMapping("/{id}")
    public CompanyRespons getCompanyById(@PathVariable Long id){
        return   companyService.getCompanyById(id);
    }
    @PutMapping("/{id}")
    public CompanyRespons updateCompany(@PathVariable Long id,@RequestBody CompanyRequest company){
        return companyService.updateCompany(id,company);

    }

    @DeleteMapping("/{id}")
    public SimpleRespons deleteCompanyById(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return new SimpleRespons("DELETED",  "Company with "+id+"  deleted");
    }
    @GetMapping("/all/{companyId}")
    public CompanyGetAllInformationResponse getAllInformationFromCompanyById(@PathVariable Long companyId){
        return companyService.getAllInformationCompanyById(companyId);
    }
    @GetMapping("/allStudent/{companyId}")
    public CompanyGetAllInfoStudent getAllInfoStudent(@PathVariable Long companyId){
        return companyService.getAllStudentInfoOnAndOff(companyId);
    }
}
