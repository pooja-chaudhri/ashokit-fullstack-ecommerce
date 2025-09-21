package com.example.entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "orders_table")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@CreationTimestamp
	private Date dateCreated;

	@UpdateTimestamp
	private Date lastUpdated;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerEntity customer;

	@ManyToOne
	@JoinColumn(name = "addressId")
	private AddressEntity address;

}
