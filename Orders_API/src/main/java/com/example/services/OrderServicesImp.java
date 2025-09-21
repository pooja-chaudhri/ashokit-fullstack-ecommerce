package com.example.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.DTO.AddressDTO;
import com.example.DTO.CustomerDTO;
import com.example.DTO.OrderDTO;
import com.example.DTO.OrderItemDTO;
import com.example.DTO.PaymentCallBackDto;
import com.example.entity.AddressEntity;
import com.example.entity.CustomerEntity;
import com.example.entity.OrderEntity;
import com.example.entity.OrderItemEntity;
import com.example.repo.AddressRepo;
import com.example.repo.CustomerRepo;
import com.example.repo.OrderItemRepo;
import com.example.repo.OrderRepo;
import com.example.request.PurchaseOrderRequest;
import com.example.response.PurchaseOrderResponse;
import com.razorpay.Order;

import lombok.SneakyThrows;

@Service
public class OrderServicesImp implements OrderServices {

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@Autowired
	private RazorPayServices payServices;
	
	@Autowired
	private EmailServices emailServices;
	
	@Override
	public PurchaseOrderResponse createOrder(PurchaseOrderRequest orderRequest) {

		CustomerDTO customerDto = orderRequest.getCustomer();
		AddressDTO addressDto = orderRequest.getAddress();
		OrderDTO orderDto = orderRequest.getOrder();
		List<OrderItemDTO> orderItemList = orderRequest.getOrderItems();
		
		CustomerEntity customer = customerRepo.findByEmail(customerDto.getEmail());
		if(customer == null) {
			//toDo: inter services communication(feign client)
			customer = new CustomerEntity();
			customer.setName(customerDto.getName());
			customer.setEmail(customerDto.getEmail());
			customer.setPhno(customerDto.getPhno());
			customerRepo.save(customer);
		}
		AddressEntity address = new AddressEntity();
		
		address.setHouseNum(addressDto.getHouseNum());
		address.setStreet(addressDto.getStreet());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setZipcode(addressDto.getZipcode());
		address.setCustomer(customer); //association mapping
		addressRepo.save(address);
		
		
		OrderEntity newOrder = new OrderEntity();
		
		String orderTrackingNum = generateOrderTrackingNum();
		newOrder.setOrderTrackingNumber(orderTrackingNum);
		Order paymentOrder = payServices.createPaymentOrder(orderDto.getTotalPrices());
		newOrder.setOrderStatus(paymentOrder.get("status"));
		newOrder.setRazorPayOrderId(paymentOrder.get("id"));
		newOrder.setTotalPrices(orderDto.getTotalPrices());
		newOrder.setTotalQuantity(orderDto.getTotalQuantity());
		newOrder.setEmail(customer.getEmail());
		
		newOrder.setCustomer(customer); //association mapping
		newOrder.setAddress(address);//association mapping
		
		orderRepo.save(newOrder);
		//save orderItem
		for(OrderItemDTO item :orderItemList) {
		  OrderItemEntity items = new OrderItemEntity();
		  System.out.println(item);
		  BeanUtils.copyProperties(item, items);
		  items.setOrder(newOrder);
		  items.setOrderItemId(null);
		  orderItemRepo.save(items);
		
		}
		//prepare and return response
		return PurchaseOrderResponse.builder()
				                    .razorPayOrderId(paymentOrder.get("id"))
				                    .OrderStatus(paymentOrder.get("status"))
				                    .OrderTrackingNumber(orderTrackingNum)
				                    .build();
		
		
	}

	@Override
	public List<OrderDTO> getOrderByEmail(String email) {
		
		List<OrderDTO> OrderList = new ArrayList<>();
		List<OrderEntity> order = orderRepo.findByEmail(email);
		for(OrderEntity orders : order) {
			OrderDTO dto = new OrderDTO();
			BeanUtils.copyProperties(orders, dto);
			OrderList.add(dto);
			
		}
		return OrderList;
	}

	@Override
	@SneakyThrows
	public PurchaseOrderResponse updateOrder(PaymentCallBackDto callbackDto) {

		OrderEntity order = orderRepo.findByRazorPayOrderId(callbackDto.getRazorpayOrderId());
		
		
		if (order == null) {
	        throw new RuntimeException("❌ Order not found for RazorPay Order ID: " + callbackDto.getRazorpayOrderId());
	    }
		if(order != null) {
			order.setOrderStatus("CONFIRMED");
			order.setDeliveryDate(LocalDate.now().plusDays(3));
			order.setRazorPayPaymentId(callbackDto.getRazorpayPaymentId());
			orderRepo.save(order);
			
			String subject = "order confirmed";
			String body = "Dear " + order.getCustomer().getName() + ",\n\n"
			        + "Thank you for shopping with AshokIT.in!\n\n"
			        + "Your order (" + order.getOrderTrackingNumber() + ") has been confirmed "
			        + "and is scheduled for delivery on " + order.getDeliveryDate() + ".\n\n"
			        + "We’ll notify you once it’s out for delivery.\n\n"
			        + "Best regards,\n"
			        + "AshokIT.in Team";			
			emailServices.sendEmail(order.getEmail(), subject, body);
		}
		//prepare and return response
		
		return PurchaseOrderResponse.builder()
                .razorPayOrderId(callbackDto.getRazorpayOrderId())
                .OrderStatus(order.getOrderStatus())
                .OrderTrackingNumber(order.getOrderTrackingNumber())
                .build();
		
	}

	private String generateOrderTrackingNum() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStamp = sdf.format(new Date());
		
		String uuid = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
		return "OD"+ timeStamp + uuid;
	}
}
