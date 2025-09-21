package com.example.services;

import org.springframework.stereotype.Service;

import com.example.DTO.CustomerDTO;
import com.example.DTO.ResetPwdDTO;
import com.example.response.AuthResponse;


@Service
public interface CustomerServices {

	public Boolean isEmailCheck(String email);
	
	public Boolean register(CustomerDTO customerDto);
	
	public Boolean resetPwd(ResetPwdDTO resepPwdDto);
	
	public CustomerDTO getCustomerByEmail(String email);
	
	public AuthResponse login(CustomerDTO customerDto);
	
	public Boolean pwdUpdate(String email);
	
	
	
	
	
}
