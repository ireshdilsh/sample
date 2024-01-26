package com.project.first_project.service.impl;

import com.project.first_project.dto.CategoryDto;
import com.project.first_project.entity.CategoryEntity;
import com.project.first_project.repository.CategoryRepository;
import com.project.first_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryEntity createCategory(CategoryDto categoryDto) {

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(categoryDto.getId());
        categoryEntity.setName(String.valueOf(categoryDto.getName()));
      //  categoryEntity.setProducts();
     return categoryRepository.save(categoryEntity);

    }
    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
    }
    @Override
    public CategoryEntity getCategorybyId(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    @Override
    public CategoryEntity updateCategory(Long id, CategoryDto categoryDto) {
        CategoryEntity categoryEntity=categoryRepository.findById(id).orElse(null);

        if (categoryEntity!=null){
            categoryEntity.setName(categoryDto.getName());
            return categoryRepository.save(categoryEntity);
        }else {
            return null;
        }
    }
}
