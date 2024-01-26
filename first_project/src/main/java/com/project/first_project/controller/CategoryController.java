package com.project.first_project.controller;

import com.project.first_project.dto.CategoryDto;
import com.project.first_project.entity.CategoryEntity;
import com.project.first_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save/category")
    private CategoryEntity createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }
    @GetMapping("/get/categories")
   private List<CategoryEntity>getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/category/get/{id}")
    private CategoryEntity getCategorybyId(@PathVariable Long id){
        return categoryService.getCategorybyId(id);
    }
    @PutMapping("/category/update/{id}")
    private CategoryEntity updateCategory(@PathVariable Long id,@RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(id,categoryDto);
    }
}
