package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;

@RestController
public class MainController {
	
	
	@Autowired
	ProductService productservice;
	
	
	@GetMapping("/fetchAllProduct")
	public List<Product> fetchProduct()
	{
		
		List<Product> result= productservice.getAllProduct();
		System.out.println(result);
		return result;
		
	}
	@GetMapping("/getAvailableProductNames")
	public List<String> listString()
	{
		List<Product> fetchProduct = fetchProduct();
		List<String> names=productservice.getAvailableProductNames(fetchProduct);
		return names;
		
	}
	
	
	

	
}
