package com.project.first_project.service;

import com.project.first_project.dto.CategoryDto;
import com.project.first_project.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryEntity createCategory(CategoryDto categoryDto);
    List<CategoryEntity> getAllCategory();

    CategoryEntity getCategorybyId(Long id);

    CategoryEntity updateCategory(Long id, CategoryDto categoryDto);
}
