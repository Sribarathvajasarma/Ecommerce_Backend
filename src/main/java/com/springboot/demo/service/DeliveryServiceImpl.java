package com.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.demo.domain.Delivery;
import com.springboot.demo.repo.DeliveryRepo;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	private DeliveryRepo deliveryRepo;
	
	
	
	
	public DeliveryServiceImpl(DeliveryRepo deliveryRepo) {
		super();
		this.deliveryRepo = deliveryRepo;
	}

	@Override
	public Delivery saveDelivery(Delivery delivery) {
		return deliveryRepo.save(delivery);
	}

	@Override
	public List<Delivery> getDeliveries() {
		
		return deliveryRepo.findAll();
	}

}
