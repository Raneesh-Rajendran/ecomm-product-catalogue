package com.ranae.ecommmarket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.ranae.ecommmarket.cache.ProductCache;
import com.ranae.ecommmarket.entity.Product;

@Repository
public class ServiceRepository {
       
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCache productCache;

    @Cacheable(value="products")
    public List<Product> getAllProducts(int pageNum) {
    	return productRepository.findAll(PageRequest.of(pageNum-1, 20, Sort.by("id"))).getContent();
    }

    @Cacheable(value="products", key="#brandName")
    public List<Product> getProductsByBrand(String brandName, int pageNum) {
    	return productRepository.findAllByBrandName(brandName, PageRequest.of(pageNum-1, 20, Sort.by("id"))).getContent();
    }

    @Cacheable(value="products", key="#maxPrice")
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice, int pageNum) {
    	return productRepository.findAllByPriceBetween(minPrice, maxPrice ,PageRequest.of(pageNum-1, 20, Sort.by("id"))).getContent();
    }

    @Cacheable(value="products", key="#productId")
    public Optional<Product> getProductBySKU(Integer productId) {
    	return productRepository.findById(productId);
    }

    @Cacheable(value="products", key="#sellerId")
    public Long getProductCountBySeller(Integer sellerId) {
    	return productRepository.countBySupplierId(sellerId);
    }

    @Cacheable(value="products", key="#size")
    public List<Product> getProductsByTypeAndSize(Integer productType, Integer size, int pageNum) {
    	return productRepository.findAllByTypeIdAndSize(productType, size ,PageRequest.of(pageNum-1, 20, Sort.by("id"))).getContent();
    }

    @Cacheable(value="products", key="#color")
    public List<Product> getProductsByTypeAndColor(Integer productType, String color, int pageNum) {
    	return productRepository.findAllByTypeIdAndColor(productType, color ,PageRequest.of(pageNum-1, 20, Sort.by("id"))).getContent();
    }

    /**
     Add a new brand through a new product entry
     */
    public void addBrand(Product product) {
        //refresh products by brand cache
        productCache.evictSingleCacheValue("productsByBrands","brandName");
        //TODO add brand code
    }

    /**
     Add a new Supplier through a new product entry
     */
    public void addSupplier(Product product) {
        //refresh products by seller cache
        productCache.evictSingleCacheValue("productCountBySeller","sellerId");
        //TODO add supplier code
    }


    /**
     Add a new Supplier through a new product entry
     */
    public void addProduct(Product product) {

        //refresh all products cache
        productCache.evictAllCacheValues("products");
        //TODO add product code
    }
}
