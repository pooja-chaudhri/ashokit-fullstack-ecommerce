package com.example.mapper;

import org.modelmapper.ModelMapper;

import com.example.DTO.CategoryDTO;
import com.example.entity.CategoryEntity;

public class CategoryMapper { 

	public static final ModelMapper modelmapper = new ModelMapper();
	
	public static final CategoryDTO ConvertToDTO(CategoryEntity entity){
		return modelmapper.map(entity,CategoryDTO.class);
	}
	
	public static final CategoryEntity ConvertToEntity(CategoryDTO categoryDto) {
		return modelmapper.map(categoryDto, CategoryEntity.class);
	}
}
