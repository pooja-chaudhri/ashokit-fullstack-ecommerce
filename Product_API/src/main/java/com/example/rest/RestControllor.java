package com.example.rest;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.CategoryDTO;
import com.example.DTO.ProductDTO;
import com.example.apiResponse.ApiResponse;
import com.example.services.ProductServices;

@RestController
@CrossOrigin(origins = "http://43.204.115.141:4200")
public class RestControllor {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping("/category")
	public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategory(){
		
		List<CategoryDTO> allCategory = productServices.getAllCategory();
		
		ApiResponse<List<CategoryDTO>> response = new ApiResponse<>();
		
		if(!allCategory.isEmpty()) {
		response.setStatus(200);
		response.setMassage(" Fetch Category successfully");
		response.setData(allCategory);
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(200);
			response.setMassage(" fail to Fetch Category");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/productById/{productId}")
	public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long productId){
		
		ProductDTO product = productServices.getProductByID(productId);
		
		ApiResponse<ProductDTO> response = new ApiResponse<>();
		if(product != null) {
		response.setStatus(200);
		response.setMassage("successfully get product byId");
		response.setData(product);
		return new  ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(200);
			response.setMassage("fail to fetch productbyId");
			response.setData(null);
			return new  ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/productByName/{name}")
	public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductByname(@PathVariable String name){
		
		List<ProductDTO> products = productServices.getProductByName(name);
		
		ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
		
		if(!products.isEmpty()) {
			response.setStatus(200);
			response.setMassage("fetch ProductByName successfully");
			response.setData(products);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(500);
			response.setMassage(" fail to fetch Product");
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	 @GetMapping("/product/{categoryId}")
	public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductByCategoryId(@PathVariable Long categoryId){
		
		List<ProductDTO> products = productServices.getProductByCategoryId(categoryId);
		
		ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
		
		if(!products.isEmpty()) {
			response.setStatus(200);
			response.setMassage("fetch Product successfully");
			response.setData(products);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			response.setStatus(500);
			response.setMassage(" fail to fetch Product");
			response.setData(Collections.emptyList());
			return new ResponseEntity<>(response,HttpStatus.OK);

		}
	}
	
	 @GetMapping("/AllProduct")
		public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProduct(){
			
			List<ProductDTO> allproduct = productServices.fetchAllProduct();
			
			ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
			
			if(!allproduct.isEmpty()) {
			response.setStatus(200);
			response.setMassage(" Fetch Product successfully");
			response.setData(allproduct);
			return new ResponseEntity<>(response,HttpStatus.OK);
			}
			else {
				response.setStatus(200);
				response.setMassage(" fail to Fetch product");
				response.setData(null);
				return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
	
	
	
	
	
	
	
	
	
}
