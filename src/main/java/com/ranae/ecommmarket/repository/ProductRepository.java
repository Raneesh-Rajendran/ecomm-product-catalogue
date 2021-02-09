package com.ranae.ecommmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ranae.ecommmarket.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findAllByBrandName(String brandName, Pageable pageRequest);

	Page<Product> findAllByPriceBetween(Double minPrice, Double maxPrice, Pageable pageRequest);

	Long countBySupplierId(Integer sellerId);

	Page<Product> findAllByTypeIdAndSize(Integer productType, Integer size, Pageable pageRequest);

	Page<Product> findAllByTypeIdAndColor(Integer productType, String color, Pageable pageRequest);


}
