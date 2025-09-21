package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.CategoryDTO;
import com.example.DTO.ProductDTO;
import com.example.entity.ProductEntity;
import com.example.mapper.CategoryMapper;
import com.example.mapper.ProductMapper;
import com.example.repo.CategoryRepo;
import com.example.repo.ProductRepo;

@Service
public class ProductServicesImp implements ProductServices {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<CategoryDTO> getAllCategory() {
		/*
		 * List<CategoryEntity> categories = categoryRepo.findAll();
		 * 
		 * List<CategoryDTO> categoryDto = new ArrayList<>();
		 * 
		 * for(CategoryEntity category : categories) { CategoryDTO dto =
		 * CategoryMapper.ConvertToDTO(category); categoryDto.add(dto); } return
		 * categoryDto;
		 */

		return categoryRepo.findAll().stream().map(CategoryMapper::ConvertToDTO).collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductByID(Long productId) {
		/*
		 * Optional<ProductEntity> byId = productRepo.findById(productId);
		 * 
		 * if(byId.isPresent()) { ProductEntity productEntity = byId.get(); return
		 * ProductMapper.ConvertToDto(productEntity); } return null;
		 */

		return productRepo.findById(productId).map(ProductMapper::ConvertToDto).orElse(null);
	}


	public List<ProductDTO> getProductByName(String name){

		List<ProductEntity> list = productRepo.findByNameContainingIgnoreCase(name);

		List<ProductDTO> products = new ArrayList<>();

		for (ProductEntity product : list) {
			ProductDTO dto = ProductMapper.ConvertToDto(product);
			products.add(dto);
		}
		return products;

		/*
		 * return productRepo.findByNameContainingIgnoreCase(name) .stream()
		 * .map(ProductMapper::ConvertToDto) .collect(Collectors.toList());
		 */

	}

	@Override
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {

		return productRepo.findByCategoryCategoryId(categoryId).stream().map(ProductMapper::ConvertToDto)
				.collect(Collectors.toList());

	}

	@Override
	public List<ProductDTO> fetchAllProduct() {

		return productRepo.findAll().stream().map(ProductMapper::ConvertToDto)
				.collect(Collectors.toList());
	}

}
