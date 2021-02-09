package com.ranae.ecommmarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranae.ecommmarket.business.ProductBusiness;
import com.ranae.ecommmarket.entity.Product;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductBusiness productBusiness;

	/**
	 * Api for fetching all products with details
	 * 
	 * @return List of products
	 */
	@GetMapping("/pageNum/{pageNum}")
	public List<Product> getAllProducts(@PathVariable("pageNum") int pageNum) {
		return productBusiness.getAllProducts(pageNum);
	}

	/**
	 * Api for fetching products details by brand
	 * 
	 * @return List of products
	 */
	@GetMapping("/brand/{brand}/pageNum/{pageNum}")
	public List<Product> getProductsByBrand(@PathVariable("brand") String brand, @PathVariable("pageNum") int pageNum) {
		return productBusiness.getProductsByBrand(brand, pageNum);
	}

	/**
	 * Api for fetching products details by price range
	 * 
	 * @return List of products
	 */
	@GetMapping("/price/min/{min}/max/{max}/pageNum/{pageNum}")
	public List<Product> getProductsByPriceRange(@PathVariable("min") Double minPrice,
			@PathVariable("max") Double maxPrice, @PathVariable("pageNum") int offset) {
		return productBusiness.getProductsByPriceRange(minPrice, maxPrice, offset);
	}

	/**
	 * Api for fetching product details by SKU
	 * 
	 * @return List of products
	 */
	@GetMapping("/{sku}")
	public Optional<Product> getProductBySKU(@PathVariable("sku") Integer productId) {
		return productBusiness.getProductBySKU(productId);
	}

	/**
	 * Api for fetching product count by seller
	 * 
	 * @return List of products
	 */
	@GetMapping("/seller/{supplier}")
	public Long getProductCountBySeller(@PathVariable("supplier") Integer sellerId) {
		return productBusiness.getProductCountBySeller(sellerId);
	}

	/**
	 * Api for fetching products details by type and size
	 * 
	 * @return List of products
	 */
	@GetMapping("/type/{type}/size/{size}/pageNum/{pageNum}")
	public List<Product> getProductsByTypeAndSize(@PathVariable("type") Integer productType,
			@PathVariable("size") Integer size, @PathVariable("pageNum") int pageNum) {
		return productBusiness.getProductsByTypeAndSize(productType, size, pageNum);
	}

	/**
	 * Api for fetching products details by type and color
	 * 
	 * @return List of products
	 */
	@GetMapping("/type/{type}/color/{color}/pageNum/{pageNum}")
	public List<Product> getProductsByTypeAndColor(@PathVariable("type") Integer productType,
			@PathVariable("color") String color, @PathVariable("pageNum") int pageNum) {
		return productBusiness.getProductsByTypeAndColor(productType, color, pageNum);
	}

	// TODO other related apis to be exposed as per needs

}
