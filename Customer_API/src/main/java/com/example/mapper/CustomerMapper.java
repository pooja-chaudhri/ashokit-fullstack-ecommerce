package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.DTO.CustomerDTO;
import com.example.entity.CustomerEntity;

@Component
public class CustomerMapper {

	public static final ModelMapper modelMapper = new ModelMapper();
	
	public static final CustomerDTO ConvertToDTO(CustomerEntity entity) {
		return modelMapper.map(entity, CustomerDTO.class);
	}
	public static final CustomerEntity ConvertToEntity(CustomerDTO dto) {
		return  modelMapper.map(dto, CustomerEntity.class);
	}
}
