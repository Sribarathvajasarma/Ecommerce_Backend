package com.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.demo.domain.Purchase;
import com.springboot.demo.repo.PurchaseRepo;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseRepo purchaseRepo;

	
	public PurchaseServiceImpl(PurchaseRepo purchaseRepo) {
		super();
		this.purchaseRepo = purchaseRepo;
	}

	@Override
	public Purchase savePurchase(Purchase purchase) {
		return purchaseRepo.save(purchase);
	}

	@Override
	public List<Purchase> getAllPurchase() {
		return purchaseRepo.findAll();
	}

}
