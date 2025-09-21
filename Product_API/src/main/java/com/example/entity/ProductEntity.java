package com.example.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name ="product_table")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String name;
	private String des;
	private String title;
	private BigDecimal unit_price;
	private String image_url;
	private Integer unit_stock;
	private Boolean active;
	
	@CreationTimestamp
	private String Date_created;
	
	@UpdateTimestamp
	private String last_updated;
	
	@ManyToOne(fetch = FetchType.EAGER)  // Change from LAZY to EAGER
	@JoinColumn(name = "categoryId", nullable = false)
	private CategoryEntity category;

}
