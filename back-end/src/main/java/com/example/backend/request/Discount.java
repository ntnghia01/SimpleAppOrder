package com.example.backend.request;

import lombok.Data;

@Data
public class Discount {
    private Amount amount;
    private String displayName;
}
