package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
		
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity getAllProduct() {
		return new ResponseEntity(productService.getAllProduct(), HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity getProduct(@PathVariable("id") int idProduct) {
		return new ResponseEntity(productService.getProduct(idProduct), HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity insertProduct(@RequestBody Product product){
		return new ResponseEntity(product, HttpStatus.OK);
	}
	
	
	
}
