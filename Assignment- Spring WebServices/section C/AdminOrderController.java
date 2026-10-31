
package com.example.smartfooddelivery.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.smartfooddelivery.model.Order;
import com.example.smartfooddelivery.repository.OrderRepository;

@RestController
@RequestMapping("/admin/orders")
public class AdminOrderController {

    private final OrderRepository orderRepository;

    public AdminOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {

        Optional<Order> order =orderRepository.findById(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        orderRepository.deleteById(id);

        return ResponseEntity.ok("Order deleted successful");
    }
}
