package com.example.projectrestapi.dto.companyDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
@Getter
@Setter
@AllArgsConstructor
public class CompanyRequest {
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
}
