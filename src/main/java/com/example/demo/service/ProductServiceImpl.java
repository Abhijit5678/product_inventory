package com.example.demo.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;
@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = Arrays.asList(
			    new Product(1, "Laptop", 50000.0, 10),
			    new Product(2, "Mouse", 500.0, 0),
			    new Product(3, "Keyboard", 1500.0, 5)
			);
		return products;
	}

	@Override
	public List<String> getAvailableProductNames(List<Product> fetchProduct) {
		return fetchProduct.stream().filter(x->x.getQuantity()>0).sorted(Comparator.comparing(Product::getPrice)).map(x->x.getName()).collect(Collectors.toList());
		 
	}

}
