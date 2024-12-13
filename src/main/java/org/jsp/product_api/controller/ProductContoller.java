package org.jsp.product_api.controller;

import java.util.List;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductContoller {
	
	@Autowired
	ProductService service;
//saving one product 
	@PostMapping("/products")
	public ResponseEntity<Object> saveProducts(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	//save multiple record
		@PostMapping("/produts/many")
		public ResponseEntity<Object> saveProducts(@RequestBody List<Product> product) {
			return service.saveProducts(product);
		}
	
	
}
