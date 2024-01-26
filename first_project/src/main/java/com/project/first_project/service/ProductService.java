package com.project.first_project.service;

import com.project.first_project.dto.ProductDto;
import com.project.first_project.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductDto productDto);

    List<ProductEntity> getAllProducts();

    ProductEntity getProductbyId(Long id);

    ProductEntity updateProduct(Long id,ProductDto productDto);
}
