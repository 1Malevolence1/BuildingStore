package com.example.product.repository;

import com.example.product.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository  extends JpaRepository<ProductType, Long> {
}
