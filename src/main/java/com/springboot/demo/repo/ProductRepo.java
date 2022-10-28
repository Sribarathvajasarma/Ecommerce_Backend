package com.springboot.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.demo.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{
	public List<Product> findByName(String name);
	
	@Query("SELECT p FROM products p where p.name LIKE %?1%")
	public List<Product> search(String name);
}
