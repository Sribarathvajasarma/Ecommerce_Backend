package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.domain.Delivery;

public interface DeliveryRepo extends JpaRepository<Delivery, Long>{
	

}
