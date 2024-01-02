package com.example.demo.service;


import com.example.demo.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> searchEmployeesByName(String name);
}
