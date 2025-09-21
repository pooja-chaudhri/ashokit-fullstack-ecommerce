package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

	
	public List<ProductEntity> findByCategoryCategoryId(Long categoryId);
	
	public List<ProductEntity> findByNameContainingIgnoreCase(String name);
}
