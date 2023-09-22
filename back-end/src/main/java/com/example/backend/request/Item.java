package com.example.backend.request;

import java.util.List;

import lombok.Data;

@Data
public class Item {
    private String sku;
    private String gtin;
    private String name;
    private String brand;
    private Amount price;
    private String category;
    private Integer quantity;
    private List<Subcategory> subcategory;
}
