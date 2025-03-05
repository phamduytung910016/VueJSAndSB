package com.ecommerce.demo.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {
    private int id;
    private String categoryName;
    private String description;
    private String imageUrl;
}
