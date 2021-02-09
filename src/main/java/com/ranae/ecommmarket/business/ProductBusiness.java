package com.ranae.ecommmarket.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranae.ecommmarket.entity.Product;
import com.ranae.ecommmarket.repository.ServiceRepository;

@Service
public class ProductBusiness {

    @Autowired
    private ServiceRepository productRepository;

    public List<Product> getAllProducts(int pageNum) {
        return productRepository.getAllProducts(pageNum);
    }

    public List<Product> getProductsByBrand(String brandName, int pageNum) {
        return productRepository.getProductsByBrand(brandName, pageNum);
    }

    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice, int pageNum) {
        return productRepository.getProductsByPriceRange(minPrice, maxPrice, pageNum);
    }

    public Optional<Product> getProductBySKU(Integer productId) {
        return productRepository.getProductBySKU(productId);
    }

    public Long getProductCountBySeller(Integer sellerId) {
        return productRepository.getProductCountBySeller(sellerId);
    }

    public List<Product> getProductsByTypeAndSize(Integer productType, Integer size, int pageNum) {
        return productRepository.getProductsByTypeAndSize(productType, size, pageNum);
    }

    public List<Product> getProductsByTypeAndColor(Integer productType, String color,  int pageNum) {
        return productRepository.getProductsByTypeAndColor(productType, color, pageNum);
    }

}
