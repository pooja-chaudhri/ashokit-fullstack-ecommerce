package com.example.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApiResponse<T> {

	private Integer status;
	private String message;
	private T data;
}
