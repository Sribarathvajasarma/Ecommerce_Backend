package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.domain.Delivery;

public interface DeliveryService {
	Delivery saveDelivery(Delivery delivery);
	List<Delivery> getDeliveries();
	

}
