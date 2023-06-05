package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.dto.companyDto.CompanyGetAllInfoStudent;
import com.example.projectrestapi.dto.companyDto.CompanyGetAllInformationResponse;
import com.example.projectrestapi.dto.companyDto.CompanyRequest;
import com.example.projectrestapi.dto.companyDto.CompanyRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.entity.Company;
import com.example.projectrestapi.exception.MyException;
import com.example.projectrestapi.repository.CompanyRepository;
import com.example.projectrestapi.service.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public CompanyRespons saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());
        companyRepository.save(company);
        return new CompanyRespons(company.getId(), company.getName(), company.getCountry(), company.getAddress(), company.getPhoneNumber());

    }

    @Override
    public CompanyRespons getCompanyById(Long id) {
//        Company company = new Company();
        return companyRepository.getCompanyById(id).orElseThrow(()
                -> new NullPointerException("Company with id " + id + "  is not found "));
//        return new CompanyRespons(company.getId(),
//                company.getName(),
//                company.getCountry(),
//                company.getAddress(),
//                company.getPhoneNumber());

    }

    @Override
    public List<CompanyRespons> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public CompanyRespons updateCompany(Long id, CompanyRequest companyRequest)  {
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new NullPointerException("User with id " + id + "  is not found "));
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());
        companyRepository.save(company);
        return new CompanyRespons(company.getId(),
                company.getName(),
                company.getCountry(),
                company.getAddress(),
                company.getPhoneNumber());
    }

    @Override
    public SimpleRespons deleteCompanyById(Long id) {
        boolean exist = companyRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Student with id: " + id + " is not found");
        }
        companyRepository.deleteById(id);
        return new SimpleRespons("DELETED", "Company with id deleted");

    }

    @Override
    public CompanyGetAllInfoStudent getAllStudentInfoOn(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()-> new NullPointerException(""));
        return CompanyGetAllInfoStudent.builder().name(company.getName()).address(company.getAddress())
                .studentInfo(companyRepository.studentInfo(id))
                .build();
    }

    @Override
    public CompanyGetAllInfoStudent getAllStudentInfoOff(Long id) {
        Company company  = companyRepository.findById(id).orElseThrow(()-> new NullPointerException(""));
        return CompanyGetAllInfoStudent.builder().name(company.getName()).address(company.getAddress())
                .studentInfo(companyRepository.studentInfoOff(id))
                .build();
    }

    @Override
    public CompanyGetAllInformationResponse getAllInformationCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new NullPointerException("User with id " + id + "  is not found "));
        return CompanyGetAllInformationResponse.builder()
                .name(company.getName())
                .address(company.getAddress())
                .groupsNames(companyRepository.groupName(id))
                .coursesNames(companyRepository.courseName(id))
                .instructorsNames(companyRepository.instructorName(id))
                .studentCount(companyRepository.studentCount(id))
                .build();
    }


}

