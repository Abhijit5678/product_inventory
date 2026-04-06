package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.Product;

public interface ProductService {

	List<Product> getAllProduct();

	List<String> getAvailableProductNames(List<Product> fetchProduct);
	List<Map<String, Object>> dataa() ;

	Map<Integer, List<Map<String, Object>>> getallformatdetails(List<Map<String, Object>> dataa);
	

}
