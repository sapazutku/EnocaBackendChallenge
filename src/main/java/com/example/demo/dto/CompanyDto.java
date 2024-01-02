package com.example.demo.dto;

import com.example.demo.entity.Company;
import com.example.demo.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyDto {
    private String name;
    private ContactDto contact;


    public CompanyDto() {
    }
    public CompanyDto(Long id, String name, Contact contact) {
        this.name = name;
        this.contact = new ContactDto(contact.getPhone(), contact.getEmail(), contact.getAddress());
    }

    public Company dtoToEntity(CompanyDto companyDto){
        Company company = new Company();
        company.setName(companyDto.getName());
        Contact contact = new Contact(
                companyDto.getContact().getPhone(),
                companyDto.getContact().getEmail(),
                companyDto.getContact().getAddress()
        );
        company.setContact(contact);
        return company;
    }
}
