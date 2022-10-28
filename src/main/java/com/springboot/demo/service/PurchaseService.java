package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.domain.Purchase;


public interface PurchaseService {
	Purchase savePurchase(Purchase purchase);
	List<Purchase> getAllPurchase();
	

}
