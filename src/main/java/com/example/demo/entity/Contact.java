package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Contact {
    private String phone;
    private String email;
    private String address;

    public Contact() {
    }

    public Contact(String phone, String email, String address) {
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
