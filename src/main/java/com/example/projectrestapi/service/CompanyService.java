package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.companyDto.CompanyGetAllInfoStudent;
import com.example.projectrestapi.dto.companyDto.CompanyGetAllInformationResponse;
import com.example.projectrestapi.dto.companyDto.CompanyRequest;
import com.example.projectrestapi.dto.companyDto.CompanyRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;

import java.util.List;

public interface CompanyService {
    CompanyRespons saveCompany(CompanyRequest companyRequest);

    CompanyRespons getCompanyById(Long id);
    List<CompanyRespons> getAllCompanies();
    CompanyGetAllInformationResponse getAllInformationCompanyById(Long id);

    CompanyRespons updateCompany(Long id,CompanyRequest companyRequest);

    SimpleRespons deleteCompanyById(Long id);

    CompanyGetAllInfoStudent getAllStudentInfoOnAndOff(Long id);
}
