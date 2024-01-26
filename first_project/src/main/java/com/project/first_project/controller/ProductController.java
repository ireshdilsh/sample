package com.project.first_project.controller;

import com.project.first_project.dto.ProductDto;
import com.project.first_project.entity.ProductEntity;
import com.project.first_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/save")
    private ProductEntity createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
    @GetMapping("/get/products")
    private List<ProductEntity>getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/get/product/{id}")
    private ProductEntity getProductbyId(@PathVariable Long id){
        return productService.getProductbyId(id);
    }
    @PutMapping("/update/product/{id}")
    private ProductEntity updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        return productService.updateProduct(id,productDto);
    }

}
