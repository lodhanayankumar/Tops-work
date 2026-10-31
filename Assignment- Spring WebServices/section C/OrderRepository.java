
package com.example.smartfooddelivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.smartfooddelivery.model.Order;

public interface OrderRepository
        extends CrudRepository<Order, Long> {
}
