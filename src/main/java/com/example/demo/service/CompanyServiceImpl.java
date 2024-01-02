package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.ContactDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setContact(companyDto.dtoToEntity(companyDto).getContact());
        Company savedCompany = companyRepository.save(company);
        return mapToDto(savedCompany);
    }

    @Override
    public CompanyDto updateCompany(Long id, CompanyDto companyDto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
        company.setName(companyDto.getName());
        company.setContact(companyDto.dtoToEntity(companyDto).getContact());
        Company updatedCompany = companyRepository.save(company);
        return mapToDto(updatedCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
        return mapToDto(company);
    }

    @Override
    public void addEmployeeToCompany(Long companyId, Long employeeId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        employee.setCompany(company);
        employeeRepository.save(employee);
    }

    private CompanyDto mapToDto(Company company) {
        CompanyDto dto = new CompanyDto(
                company.getId(),
                company.getName(),
                company.getContact()
        );
        dto.setName(company.getName());
        ContactDto contactDto = new ContactDto(
                company.getContact().getPhone(),
                company.getContact().getEmail(),
                company.getContact().getAddress()
        );
        dto.setContact(contactDto);
        return dto;
    }
}