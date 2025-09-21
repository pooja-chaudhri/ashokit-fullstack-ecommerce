
package com.example.entity;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "customer_table")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String name;
	private String email;
	private BigInteger phno;
	private String pwd;
	private String pwd_updated;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date lastUpdatedDate;
	

}
