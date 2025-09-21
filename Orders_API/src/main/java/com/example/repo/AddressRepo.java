package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Long> {

}
