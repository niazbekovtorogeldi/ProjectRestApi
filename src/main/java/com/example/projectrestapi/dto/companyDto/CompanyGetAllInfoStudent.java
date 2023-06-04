package com.example.projectrestapi.dto.companyDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGetAllInfoStudent {
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private List<String> studentInfo;
}
