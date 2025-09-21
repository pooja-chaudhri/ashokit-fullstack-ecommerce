package com.example.services;

import org.springframework.stereotype.Repository;

import com.razorpay.Order;

@Repository
public interface RazorPayServices {

	public Order createPaymentOrder(Double amount);
	
}
