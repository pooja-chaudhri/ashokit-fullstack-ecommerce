package com.example.DTO;




import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderItemDTO {

	private Long orderItemId;
	
	 @JsonProperty("name") 
	private String name;
	
	private String image_url;
	
	private Double unit_price;
	 
	private Integer quantity;
	
	
	
}
