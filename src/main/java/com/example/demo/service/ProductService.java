package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
@Service
public class ProductService {
	
	public List<Product> getAllProduct() {	
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Biscuit", 2000));
		products.add(new Product(2, "Boisson", 3000));
		products.add(new Product(3, "Bonbon", 500));
		return products;
	}
	
	public Product getProduct(int idProduct) {
		return new Product(idProduct, "Sambosa", 200);
	}
	
}
