package com.example.response;

import lombok.Data;

@Data
public class ApiResponse<T>{
	
	private Integer status;
	private String massage;
	private T data;

}
