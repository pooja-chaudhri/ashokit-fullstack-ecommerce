package com.example.DTO;


import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
public class ProductDTO {

	private Long productId;
	private String name;
	private String des;
	private String title;
	private BigDecimal unit_price;
	private String image_url;
	private Integer unit_stock;
	private Boolean active;
	
	
	@CreationTimestamp
	private Date dateCreated;

	@UpdateTimestamp
	private Date lastUpdated;
	
}
