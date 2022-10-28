package com.springboot.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.domain.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Long>{

}
