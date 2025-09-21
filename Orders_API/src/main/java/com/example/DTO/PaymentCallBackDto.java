package com.example.DTO;

import lombok.Data;

@Data
public class PaymentCallBackDto {

	private String razorpayOrderId;
	private String razorpayPaymentId;
	private String razorpaySignature;
}
