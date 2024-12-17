package org.jsp.product_api.controller;

import java.util.List;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    // Saving one product 
    @PostMapping("/products")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    // Save multiple records
    @PostMapping("/products/many")
    public ResponseEntity<Object> saveProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    // Fetch All Products
    @GetMapping("/products")
    public ResponseEntity<Object> fetchAllProducts() {
        return service.fetchAllProducts();
    }

    // Fetch by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> fetchById(@PathVariable int id) {
        return service.fetchById(id);
    }

    // Fetch product by name
    @GetMapping("/products/name/{name}")
    public ResponseEntity<Object> fetchByName(@PathVariable String name) {
        return service.fetchByName(name);
    }

    // Fetch products price greater than
    @GetMapping("/products/price/greater/{price}")
    public ResponseEntity<Object> fetchByGreaterThanEqual(@PathVariable double price) {
        return service.fetchByGreaterThanEqual(price);
    }
    
    //fetch Products By Stock Between
    @GetMapping("/products/stock/{min}/{max}")
    public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min, @PathVariable int max){
        return service.fetchByStockBetween(min, max);
    }

}
