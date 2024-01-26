package com.project.first_project.service.impl;

import com.project.first_project.dto.OrderDto;
import com.project.first_project.entity.OrderEntity;
import com.project.first_project.entity.ProductEntity;
import com.project.first_project.repository.OrderRepository;
import com.project.first_project.repository.ProductRepository;
import com.project.first_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderEntity updateOrder(Long id, OrderEntity orderDto) {
        return null;
    }

    @Override
    public OrderEntity getOrderbyID(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderEntity> getAllOders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity createOder(OrderDto orderDto) {
        List<Long> productIds = orderDto.getProducts();

        Set<ProductEntity> products = new HashSet<>();
        Double total = 0.0;

        for(Long productId : productIds) { //Looping through product Ids.
            ProductEntity product = productRepository.findById(productId).orElse(null);

            if(product != null && product.getQty() != 0) {
                //add this to the Product Set
                products.add(product);
                total = total + product.getPrice();

                product.setQty(product.getQty() - 1);
                productRepository.save(product);
            }
        }

        Double tax = (total/100) * 15;
        LocalDateTime dateTime = LocalDateTime.now();

        OrderEntity order = new OrderEntity();
        order.setTotal(total);
        order.setTax(tax);
        order.setDateTime(dateTime);
        order.setProducts(products);

        return orderRepository.save(order);
    }
    }

