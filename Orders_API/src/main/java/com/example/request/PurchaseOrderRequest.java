package com.example.request;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DTO.AddressDTO;
import com.example.DTO.CustomerDTO;
import com.example.DTO.OrderDTO;
import com.example.DTO.OrderItemDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseOrderRequest {

	private CustomerDTO customer;
	private AddressDTO address;
	private OrderDTO order;
	private List<OrderItemDTO> orderItems;
	
}
