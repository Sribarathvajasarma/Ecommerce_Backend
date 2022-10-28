package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.demo.domain.Product;
import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;
	
	public ProductServiceImpl(ProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}


	@Override
	public Product getProductbyId(long id) {
		Optional<Product> product = productRepo.findById(id);
	    
		if(product.isPresent()) {
			return product.get();
			
		}else {
			throw new ResourceNotFoundException("Product", "Id", id);
		}
	 
	}


	@Override
	public Product updateProduct(Product product, long id) {
		Product existingProduct = productRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Product", "Id", id));
		
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		
		productRepo.save(existingProduct);
		return existingProduct;
		
	}


	@Override
	public void deleteProduct(long id) {
		
		productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", id));
		productRepo.deleteById(id);
	}
	
	@Override
	public List<Product> abcd(String name) {
		
		return productRepo.search(name);
	}

	

	
	
	

}
