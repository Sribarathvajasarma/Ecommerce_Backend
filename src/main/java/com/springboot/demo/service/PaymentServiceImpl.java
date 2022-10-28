package com.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.demo.domain.Payment;
import com.springboot.demo.repo.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	private PaymentRepo paymentRepo;

	
	
	public PaymentServiceImpl(PaymentRepo paymentRepo) {
		super();
		this.paymentRepo = paymentRepo;
	}



	@Override
	public Payment savePayment(Payment payment) {
		
		return paymentRepo.save(payment);
	}



	@Override
	public List<Payment> getPayments() {
		return paymentRepo.findAll();
	}

	

}
