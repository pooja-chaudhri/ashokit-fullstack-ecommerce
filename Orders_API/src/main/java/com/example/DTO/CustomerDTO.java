package com.example.DTO;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDTO {
	private String name;
	private String email;
	private BigInteger phno;
}
