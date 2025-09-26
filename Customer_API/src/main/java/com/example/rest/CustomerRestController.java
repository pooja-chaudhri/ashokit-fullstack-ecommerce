package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.CustomerDTO;
import com.example.DTO.ResetPwdDTO;
import com.example.response.ApiResponse;
import com.example.response.AuthResponse;
import com.example.services.CustomerServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://43.204.115.141:4200"})
public class CustomerRestController {

	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<String>> register(@RequestBody CustomerDTO customerDto){
		
		ApiResponse<String> response = new ApiResponse<>();

		Boolean emailCheck = customerServices.isEmailCheck(customerDto.getEmail());

		if(!emailCheck ) {
			response.setStatus(400);
			response.setMessage("fail");
			response.setData("duplicate email");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		Boolean register = customerServices.register(customerDto);
		if(register != null) {
			response.setStatus(201);
			response.setMessage("sucess");
			response.setData("Registration sucessfull");
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
		else {
			response.setStatus(500);
			response.setMessage("fail");
			response.setData("Registration fail");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody CustomerDTO customerDto){
		
		ApiResponse<AuthResponse> response = new ApiResponse<>();

		AuthResponse login = customerServices.login(customerDto);
		if(login != null) {
			response.setStatus(201);
			response.setMessage("login sucess");
			response.setData(login);
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
		else {
			response.setStatus(400);
			response.setMessage("Invalid credentials");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/resetPwd")
	public ResponseEntity<ApiResponse<String>> resetPwd(@RequestBody ResetPwdDTO resetDto){
		
		ApiResponse<String> response = new ApiResponse<>();
		
		Boolean status = customerServices.resetPwd(resetDto);
		
		if (status) {
			response.setStatus(200);
			response.setMessage("success");
			response.setData("Password updated successfully");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		else {
			response.setStatus(400);
			response.setMessage("failed");
			response.setData("Current password incorrect or reset failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/forgotpwd/{email}")
	public ResponseEntity<ApiResponse<String>> updatePwd(@PathVariable String email){
		ApiResponse<String> response = new ApiResponse<>();
		
		Boolean status = customerServices.pwdUpdate(email);
		if(status) {
			response.setStatus(200);
			response.setMessage("sucess");
			response.setData("email sent to update password");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(400);
			response.setMessage("failed");
			response.setData("record not found");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
}
































