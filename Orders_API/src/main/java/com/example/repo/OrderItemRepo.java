package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderItemEntity;

public interface OrderItemRepo extends JpaRepository<OrderItemEntity, Long> {

}
