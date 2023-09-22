package com.example.backend.request;

import lombok.Data;

@Data
public class Merchant {
    private String redirectCancelUrl;
    private String redirectConfirmUrl;
}
