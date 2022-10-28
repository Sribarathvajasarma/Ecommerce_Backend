package com.springboot.demo.service;

import java.util.List;


import com.springboot.demo.domain.Product;

public interface ProductService {
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductbyId(long id);
	Product updateProduct(Product product, long id);
	void deleteProduct(long id);
	List<Product> abcd(String name);
}
