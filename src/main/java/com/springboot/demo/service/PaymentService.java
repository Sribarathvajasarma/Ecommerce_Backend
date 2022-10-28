package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.domain.Payment;

public interface PaymentService {
	Payment savePayment(Payment payment);
	List<Payment> getPayments();

}
