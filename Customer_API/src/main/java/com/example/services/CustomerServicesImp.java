package com.example.services;

import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DTO.CustomerDTO;
import com.example.DTO.ResetPwdDTO;
import com.example.email.EmailServices;
import com.example.entity.CustomerEntity;
import com.example.mapper.CustomerMapper;
import com.example.repo.CustomerRepo;
import com.example.response.AuthResponse;

import lombok.SneakyThrows;

@Service
public class CustomerServicesImp implements CustomerServices,UserDetailsService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private EmailServices emailServices;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTServices jwtServices;
	
	Random rnd = new Random();
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		CustomerEntity c = customerRepo.findByEmail(email);
		return new User(c.getEmail(), c.getPwd(), Collections.emptyList());
	}

	@Override
	public Boolean isEmailCheck(String email) {
		CustomerEntity c = customerRepo.findByEmail(email);
		return c == null;
	}

	@Override
	@SneakyThrows
	public Boolean register(CustomerDTO customerDto) {

		String orgPwd = getRandomPwd();
		String encode = pwdEncoder.encode(orgPwd);
		CustomerEntity entity = CustomerMapper.ConvertToEntity(customerDto);
		entity.setPwd(encode);
		
		CustomerEntity save = customerRepo.save(entity);
		
		if(save.getCustomerId() != null) {
			String subject = " Resgistraction sucess";
			String body = " login sucessfull, your login password : "+ orgPwd;
			emailServices.sendEmail(customerDto.getEmail(), subject, body);
			return true;
		}
		return false;
	}

	@Override
	public Boolean resetPwd(ResetPwdDTO resetDto) {

		CustomerEntity Entity = customerRepo.findByEmail(resetDto.getEmail());
		
		if(Entity == null) return false;
		
		String stored = Entity.getPwd();		
		if(stored == null || stored.isEmpty()) {
			return false;
		}
		if(!pwdEncoder.matches(resetDto.getOldPwd(), stored)) {
			return false;
		}
		
		String encode = pwdEncoder.encode(resetDto.getNewPwd());
	    Entity.setPwd(encode);
	    Entity.setPwd_updated("yes");
	    customerRepo.save(Entity);
	    
	    return true;
	}
		
//		if(Entity != null) {
//			
//			if(!pwdEncoder.matches(resetDto.getOldPwd(), Entity.getPwd())) {
//				return false;
//			}
//			
//		String encode = pwdEncoder.encode(resetDto.getNewPwd());
//		Entity.setPwd(encode);
//		Entity.setPwd_updated("yes");
//		customerRepo.save(Entity);
//		return true;
//		}
//		
//		return false;
	

	@Override
	public CustomerDTO getCustomerByEmail(String email) {

		CustomerEntity entity = customerRepo.findByEmail(email);
		if(entity != null) {
		CustomerDTO dto = CustomerMapper.ConvertToDTO(entity);
		return dto;
		}
		return null;
	}

	@Override
	public AuthResponse login(CustomerDTO customerDto) {

		AuthResponse response = new AuthResponse();
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(customerDto.getEmail(),customerDto.getPassword());
		
		Authentication authenticate = authManager.authenticate(authToken);
		
		if(authenticate.isAuthenticated()) {
			CustomerEntity entity = customerRepo.findByEmail(customerDto.getEmail());
			response.setCustomerDto(CustomerMapper.ConvertToDTO(entity));
			response.setJwtToken(jwtServices.generateToken(customerDto.getEmail()));
		}
		
		return response;
	}
	
    @Override
    @SneakyThrows
    public Boolean pwdUpdate(String email) {
    	CustomerEntity customer = customerRepo.findByEmail(email);
    	if(customer != null) {
    		String subject = "update Request";
    		String body = "temp body";
    		emailServices.sendEmail(email, subject, body);
    		return true;
    	}
    	
    	return false;
    }

	private String getRandomPwd() {
		
		final String ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

	        StringBuilder pwd = new StringBuilder();

	        while (pwd.length() < 6) {
	            int index = rnd.nextInt(ch.length()); // Generate a random index
	            pwd.append(ch.charAt(index));
	        }

	        return pwd.toString();
	    }


	
}
