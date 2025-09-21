package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long>{

	public CustomerEntity findByEmail(String email);
}
