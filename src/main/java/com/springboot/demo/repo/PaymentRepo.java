package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.domain.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
