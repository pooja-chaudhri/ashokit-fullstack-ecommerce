package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

	public OrderEntity findByRazorPayOrderId(String razorPayOrderId);
	
	public List<OrderEntity> findByEmail(String email);

}
