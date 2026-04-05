package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Product;

public interface ProductService {

	List<Product> getAllProduct();

	List<String> getAvailableProductNames(List<Product> fetchProduct);
	

}
