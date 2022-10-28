package com.springboot.demo.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.domain.Delivery;
import com.springboot.demo.service.DeliveryService;

@RestController
@RequestMapping("/api")
public class DeliveryResource {
	
	private DeliveryService deliveryService;

	
	public DeliveryResource(DeliveryService deliveryService) {
		super();
		this.deliveryService = deliveryService;
	}

	@PostMapping("/delivery")
	public ResponseEntity<Delivery> saveDelivery(@RequestBody Delivery delivery){
		return new ResponseEntity<Delivery>(deliveryService.saveDelivery(delivery), HttpStatus.CREATED);
		
	}
	


	@GetMapping("/delivery")
	public List<Delivery> getAllDeliveries(){
		return deliveryService.getDeliveries();
	}
	

}