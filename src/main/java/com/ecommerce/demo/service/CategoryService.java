package com.ecommerce.demo.service;

import com.ecommerce.demo.controller.dto.CategoryDTO;
import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Transactional
    public void createCategory(CategoryDTO categoryDTO) {
        categoryRepo.save(Category.toEntity(categoryDTO));
    }

}
