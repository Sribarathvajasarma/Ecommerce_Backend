package com.springboot.demo.api;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.domain.Purchase;
import com.springboot.demo.service.PurchaseService;

@RestController
@RequestMapping("/api")
public class PurchaseResouce {
	
	private PurchaseService purchaseService;

	
	
	
	public PurchaseResouce(PurchaseService purchaseService) {
		super();
		this.purchaseService = purchaseService;
	}

	@PostMapping("/purchase")
	public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase){

		return new ResponseEntity<Purchase>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
	}
	
	@GetMapping("/purchase")
	public List<Purchase> getAllPurchase(){
		System.out.println("get product called");
		return purchaseService.getAllPurchase();
	}
	
	
}
