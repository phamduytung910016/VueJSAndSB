package com.ecommerce.demo.model;

import com.ecommerce.demo.controller.dto.CategoryDTO;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "category_test")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "category_name", nullable = false)
    public String categoryName;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "image_url", nullable = false)
    public String imageUrl;

    public static Category toEntity(CategoryDTO dto){
        return new Category(dto.getId(), dto.getCategoryName(), dto.getDescription(), dto.getImageUrl());
    }
}
