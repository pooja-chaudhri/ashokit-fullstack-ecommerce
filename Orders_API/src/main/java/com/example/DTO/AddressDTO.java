package com.example.DTO;

import lombok.Data;

@Data
public class AddressDTO {
	private String houseNum;
	private String street;
	private String city;
	private String state;
	private Integer zipcode;
}
