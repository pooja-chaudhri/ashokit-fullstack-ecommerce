package com.example.entity;

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
@Table(name = "orderItem_table")
public class OrderItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
	private String name;
	private String image_url;
	private Double unit_price;
	private Integer quantity;
	
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private OrderEntity order;

}
