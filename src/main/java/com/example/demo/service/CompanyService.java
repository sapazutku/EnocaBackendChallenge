package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import org.springframework.stereotype.Service;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto updateCompany(Long id, CompanyDto companyDto);

    void deleteCompany(Long id);

    CompanyDto getCompanyById(Long id);

    void addEmployeeToCompany(Long companyId, Long employeeId);
}
