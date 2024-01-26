package com.project.first_project.service.impl;

import com.project.first_project.dto.ProductDto;
import com.project.first_project.entity.CategoryEntity;
import com.project.first_project.entity.ProductEntity;
import com.project.first_project.repository.CategoryRepository;
import com.project.first_project.repository.ProductRepository;
import com.project.first_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
   @Autowired
   private CategoryRepository categoryRepository;
    @Override
    public ProductEntity createProduct(ProductDto productDto) {

        ProductEntity productEntity = new ProductEntity();
        CategoryEntity categoryEntity=categoryRepository.findById(productDto.getCategoryid()).orElse(null);

      if (categoryEntity!=null){
          productEntity.setId(productDto.getId());
          productEntity.setName(productDto.getName());
          productEntity.setPrice(productDto.getPrice());
          productEntity.setQty(productDto.getQty());
          productEntity.setCategoryEntity(categoryEntity);

          return productRepository.save(productEntity);
      }else {
          return null;
      }
    }
    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public ProductEntity getProductbyId(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public ProductEntity updateProduct(Long id,ProductDto productDto) {

        ProductEntity productEntity=productRepository.findById(id).orElse(null);

        if (productEntity!=null){

            productEntity.setName(productDto.getName());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setQty(productDto.getQty());
            productEntity.setCategoryEntity(productEntity.getCategoryEntity());

            return productRepository.save(productEntity);

        }else {
            return null;
        }
    }
}
