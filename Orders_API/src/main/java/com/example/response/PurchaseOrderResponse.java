package com.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseOrderResponse {

	private String razorPayOrderId;
	private String OrderStatus;
	private String OrderTrackingNumber;
}
