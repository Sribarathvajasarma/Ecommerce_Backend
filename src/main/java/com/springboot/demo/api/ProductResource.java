package com.springboot.demo.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.domain.Product;
import com.springboot.demo.service.ProductService;



@RestController
@RequestMapping("/api")
public class ProductResource {
	
	private ProductService productService;
	
	
	
	public ProductResource(ProductService productService) {
		super();
		this.productService = productService;
	}



	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){

		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		System.out.println("get product called");

		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
		return new ResponseEntity<Product>(productService.getProductbyId(productId), HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId, @RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, productId), HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
		
	}
	
	@GetMapping("/product/query")
	public List<Product> searchProduct(@RequestParam(name= "name") String name){
		return productService.abcd(name);
		
	}
	
	

}
