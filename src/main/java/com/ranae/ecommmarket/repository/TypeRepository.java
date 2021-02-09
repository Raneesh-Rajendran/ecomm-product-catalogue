package com.ranae.ecommmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranae.ecommmarket.entity.ProductType;

public interface TypeRepository extends JpaRepository<ProductType, Integer> {


}