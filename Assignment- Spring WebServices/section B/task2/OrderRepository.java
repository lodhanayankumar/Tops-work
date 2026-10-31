package com.example.foodmenu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.foodmenu.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomerName(String name);
}