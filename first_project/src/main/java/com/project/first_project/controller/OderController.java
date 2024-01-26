package com.project.first_project.controller;

import com.project.first_project.dto.OrderDto;
import com.project.first_project.entity.OrderEntity;
import com.project.first_project.service.OrderService;
import com.project.first_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @PostMapping("/save/order")
    private OrderEntity createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOder(orderDto);
    }
    @GetMapping("/get/all/oders")
    private ResponseEntity<List<OrderEntity>>getAllOders(){
        return ResponseEntity.status(200).body(orderService.getAllOders());
    }
    @GetMapping("/get/order/id/{id}")
    private ResponseEntity<OrderEntity> getOderbyId(@PathVariable Long id){
       return ResponseEntity.status(200).body(orderService.getOrderbyID(id));
    }
    @PutMapping("/update/order/id/{id}")
    private OrderEntity updateOrder(@PathVariable Long id,@RequestBody OrderEntity orderEntity){
        return orderService.updateOrder(id,orderEntity);
    }
}
