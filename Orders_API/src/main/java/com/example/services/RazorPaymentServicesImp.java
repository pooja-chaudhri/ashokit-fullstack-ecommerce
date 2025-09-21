package com.example.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.SneakyThrows;

@Service
public class RazorPaymentServicesImp implements RazorPayServices {
	
	@Value("${razorpay.key}")
	private String keyId;
	
	@Value("${razorpay.secret}")
	private String keySecret;
	private RazorpayClient razorPayClient;
	
	
	@Override
	@SneakyThrows
	public Order createPaymentOrder(Double amount) {
				
		this.razorPayClient = new RazorpayClient(keyId, keySecret);
		
		
		 // Example exchange rate (1 USD = 83 INR)
	    double exchangeRate = 83.0;

	    // Convert USD → INR
	    double amountInINR = amount * exchangeRate;

	    // Razorpay expects amount in paise
	    int finalAmount = (int) (amountInINR * 100);
	    
	    JSONObject orderRequest = new JSONObject();
		
		//orderRequest.put("amount", amount*100);
	    
		orderRequest.put("amount", finalAmount);
		orderRequest.put("currency", "INR");
		orderRequest.put("payment_capture", 1);
		return razorPayClient.orders.create(orderRequest);
		
	}

}
