package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.OrderDTO;
import com.example.DTO.PaymentCallBackDto;
import com.example.entity.OrderEntity;
import com.example.request.PurchaseOrderRequest;
import com.example.response.ApiResponse;
import com.example.response.PurchaseOrderResponse;
import com.example.services.OrderServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://43.204.220.254:4200"})
public class orderRestController {

	@Autowired
	private OrderServices orderServices;

	@PostMapping("/createOrder")
	private ResponseEntity<ApiResponse<PurchaseOrderResponse>> createOrder(@RequestBody PurchaseOrderRequest request) {
		
		ApiResponse<PurchaseOrderResponse> response = new ApiResponse<>();
		
		PurchaseOrderResponse order = orderServices.createOrder(request);
		
		if(order != null) {
			response.setStatus(200);
			response.setMassage("order created");
			response.setData(order);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(500);
			response.setMassage("order creation failed");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping("/updateOrder")
	private ResponseEntity<ApiResponse<PurchaseOrderResponse>> updateOrder(@RequestBody PaymentCallBackDto callbackDto){
		
		ApiResponse<PurchaseOrderResponse> response = new ApiResponse<>();
		
		PurchaseOrderResponse order = orderServices.updateOrder(callbackDto);
		
		if(order != null) {
			response.setStatus(200);
			response.setMassage("order updated");
			response.setData(order);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(200);
			response.setMassage("order updated fail");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/orders/{email}")
	public ResponseEntity<ApiResponse<List<OrderDTO>>> getOrder(@PathVariable String email){
		
		ApiResponse<List<OrderDTO>> response = new ApiResponse<>();
		
		List<OrderDTO> orderList = orderServices.getOrderByEmail(email);
		
		if(!orderList.isEmpty()) {
			response.setStatus(200);
			response.setMassage("fetch Order");
			response.setData(orderList);
           return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(400);
			response.setMassage("failed to fetch Order");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
}



















