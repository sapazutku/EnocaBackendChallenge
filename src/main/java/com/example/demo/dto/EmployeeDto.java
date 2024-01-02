package com.example.demo.dto;

import com.example.demo.entity.Contact;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private String name;

    private String surname;

    private int age;

    private int salary;

    private ContactDto contact;

    private Long companyId;
}
