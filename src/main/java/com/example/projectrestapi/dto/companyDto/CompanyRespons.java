package com.example.projectrestapi.dto.companyDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRespons {
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;

    public CompanyRespons(Long id, String name, String country, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
