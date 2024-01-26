package com.project.first_project.service;

import com.project.first_project.dto.OrderDto;
import com.project.first_project.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderEntity updateOrder(Long id, OrderEntity orderDto);

    OrderEntity getOrderbyID(Long id);

    List<OrderEntity> getAllOders();

    OrderEntity createOder(OrderDto orderDto);

    //   OrderEntity createOder(OrderDto orderDto);
}
