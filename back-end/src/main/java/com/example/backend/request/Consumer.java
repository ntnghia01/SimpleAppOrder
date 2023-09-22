package com.example.backend.request;

import lombok.Data;

@Data
public class Consumer {
    private String email;
    private String surname;
    private String givenNames;
    private String phoneNumber;
}
