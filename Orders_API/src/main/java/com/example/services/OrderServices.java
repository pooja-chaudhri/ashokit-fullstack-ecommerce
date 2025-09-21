package com.example.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.DTO.OrderDTO;
import com.example.DTO.PaymentCallBackDto;
import com.example.entity.OrderEntity;
import com.example.request.PurchaseOrderRequest;
import com.example.response.PurchaseOrderResponse;

@Service
public interface OrderServices {

	public  PurchaseOrderResponse createOrder(PurchaseOrderRequest orderRequest);
	
	public List<OrderDTO> getOrderByEmail(String email);
	
	public PurchaseOrderResponse updateOrder(PaymentCallBackDto callbackDto);
}
