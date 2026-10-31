package com.example.smartfooddelivery.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.smartfooddelivery.dto.OrderRequest;
import com.example.smartfooddelivery.model.Order;
import com.example.smartfooddelivery.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//new order
    @PostMapping
    public ResponseEntity<Order> placeOrder(
            @Valid @RequestBody OrderRequest request) {

        Order order = new Order(
                request.getCustomerName(),
                request.getItemName(),
                request.getQuantity(),
                request.getTotalAmount());

        Order savedOrder = orderRepository.save(order);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedOrder);
    }

//using ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {

        return orderRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Order not found")));
    }
}
