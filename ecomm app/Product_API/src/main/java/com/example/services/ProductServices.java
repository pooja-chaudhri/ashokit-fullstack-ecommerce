package com.example.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.DTO.CategoryDTO;
import com.example.DTO.ProductDTO;

@Service
public interface ProductServices {
	
	public List<CategoryDTO> getAllCategory();

	public ProductDTO getProductByID(Long productId);
	
	public List<ProductDTO> getProductByName(String name);
	
	public List<ProductDTO> getProductByCategoryId(Long categoryId);
	
	public List<ProductDTO> fetchAllProduct();
	
}
