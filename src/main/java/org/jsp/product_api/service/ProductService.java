package org.jsp.product_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public ResponseEntity<Object> saveProduct(Product product) {
        repository.save(product);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Product added successfully");
        map.put("data", product);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> saveProducts(List<Product> products) {
        repository.saveAll(products);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Products added successfully");
        map.put("data", products);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> fetchAllProducts() {
        List<Product> list = repository.findAll();
        if (list.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "No products found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Products found successfully");
            map.put("data", list);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> fetchById(int id) {
        Optional<Product> optional = repository.findById(id);
        if (optional.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "No product found by ID: " + id);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Product found successfully");
            map.put("data", optional.get());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> fetchByName(String name) {
        List<Product> list = repository.findByName(name);
        if (list.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "No product found by name: " + name);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Product(s) found successfully");
            map.put("data", list);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> fetchByGreaterThanEqual(double price) {
        List<Product> list = repository.findByPriceGreaterThanEqual(price);
        if (list.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "No product found with price greater than or equal to: " + price);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Product(s) found successfully");
            map.put("data", list);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    public ResponseEntity<Object> fetchByStockBetween(int min, int max) { 
    	List<Product> list = repository.findByStockBetween(min, max); 
    	if (list.isEmpty()) { Map<String, Object> map = new HashMap<>(); 
    	map.put("error", "No products found in the stock range " + min + " to " + max);
    	return new ResponseEntity<>(map, HttpStatus.NOT_FOUND); 
    	} 
    	else { 
    		Map<String, Object> map = new HashMap<>();
    		map.put("message", "Products found successfully");
    		map.put("data", list); return new ResponseEntity<>(map, HttpStatus.OK); 
    		}
    }
}
