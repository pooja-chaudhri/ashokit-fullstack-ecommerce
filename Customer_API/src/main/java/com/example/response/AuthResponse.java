package com.example.response;

import com.example.DTO.CustomerDTO;

import lombok.Data;

@Data
public class AuthResponse {

	private CustomerDTO customerDto;
	
	private String JwtToken;
}
