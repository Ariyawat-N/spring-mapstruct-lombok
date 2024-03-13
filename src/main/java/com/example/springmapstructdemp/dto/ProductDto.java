package com.example.springmapstructdemp.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

    @Id
    private int id;
    private String name;
    private String description;
    private String quantity;
    private long price;
}
