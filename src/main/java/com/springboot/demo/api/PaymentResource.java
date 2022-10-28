package com.springboot.demo.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.domain.Payment;
import com.springboot.demo.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentResource {
	
	private PaymentService paymentService;

	public PaymentResource(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@PostMapping("/payment")
	public ResponseEntity<Payment> savePurchase(@RequestBody Payment payment){

		return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
	}
	
	@GetMapping("/payment")
	public List<Payment> getAllPayment(){
		return paymentService.getPayments();
	}

}
