package com.example.DTO;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {

	private Long orderId;
	private String orderTrackingNumber;
	private String email;
	private Integer totalQuantity;
	private Double totalPrices;
	private String orderStatus;
	private String invoiceUrl;
	private LocalDate deliveryDate;
	private String razorPayOrderId;
	private String razorPayPaymentId;
}
