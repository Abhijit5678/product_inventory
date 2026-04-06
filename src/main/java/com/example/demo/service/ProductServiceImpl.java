package com.example.demo.service;

import java.util.Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
@Slf4j
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

	@Override
	public List<Map<String, Object>> dataa() {
		List<Map<String, Object>> data = List.of(
			    Map.of("productId", 101, "supplierId", 1, "price", 200),
			    Map.of("productId", 101, "supplierId", 2, "price", 180),
			    Map.of("productId", 102, "supplierId", 3, "price", 300)
			);
		return data;
	}

	@Override
	public Map<Integer, List<Map<String, Object>>> getallformatdetails(List<Map<String, Object>> dataa) {
		log.info("insert to the method");
		
		return dataa.stream()
			    .collect(Collectors.groupingBy(
			            item -> (Integer) item.get("productId"),
			            Collectors.mapping(
			                item -> {
			                    Map<String, Object> map = new HashMap<>();
			                    map.put("supplierId", item.get("supplierId"));
			                    map.put("price", item.get("price"));
			                    return map;
			                },
			                Collectors.toList()
			            )
			        ));
	}

}
