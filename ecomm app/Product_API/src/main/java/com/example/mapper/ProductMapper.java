package com.example.mapper;

import org.modelmapper.ModelMapper;

import com.example.DTO.ProductDTO;
import com.example.entity.ProductEntity;

public class ProductMapper {

	public static final ModelMapper modelmapper = new ModelMapper();
	
	public static final ProductDTO ConvertToDto(ProductEntity entity) {
		return modelmapper.map(entity, ProductDTO.class);
	}
	
	public static final ProductEntity ConvertToEntity(ProductDTO productDto) {
		return modelmapper.map(productDto, ProductEntity.class);
	}
	
}
