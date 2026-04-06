package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;

@RestController
public class MainController {

	private final ProductService productService;

	public MainController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/fetchAllProduct")
	public List<Product> fetchProduct() {

		List<Product> result = productService.getAllProduct();
		System.out.println(result);
		return result;

	}

	@GetMapping("/getInStockProductNamesSortedByPrice")
	public List<String> listString() {
		List<Product> fetchProduct = productService.getAllProduct();
		List<String> names = productService.getAvailableProductNames(fetchProduct);
		return names;

	}
	@GetMapping("/getProductUsingSupplyId")
	public Map<Integer, List<Map<String, Object>>> getdetails()
	{
		List<Map<String, Object>> dataa = productService.dataa();
		
		Map<Integer, List<Map<String, Object>>> result=productService.getallformatdetails(dataa);
		return result;
		
	}
	

}
