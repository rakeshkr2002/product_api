package org.jsp.product_api.repository;

import org.jsp.product_api.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
