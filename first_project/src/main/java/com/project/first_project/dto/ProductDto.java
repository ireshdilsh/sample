package com.project.first_project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private int qty;
    private Long categoryid;
}
