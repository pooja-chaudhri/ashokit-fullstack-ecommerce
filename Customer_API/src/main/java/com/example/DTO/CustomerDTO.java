package com.example.DTO;

import java.math.BigInteger;

import lombok.Data;

@Data
public class CustomerDTO {

	private Integer customerId;
	private String name;
	private String email;
	private  BigInteger phno;
	private String password;
	private String pwd_updated;
}
