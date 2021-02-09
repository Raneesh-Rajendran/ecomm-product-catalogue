package com.aniruddha.XYZecommmarket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.ranae.ecommmarket.business.ProductBusiness;
import com.ranae.ecommmarket.entity.Brand;
import com.ranae.ecommmarket.entity.Product;
import com.ranae.ecommmarket.entity.ProductType;
import com.ranae.ecommmarket.entity.Supplier;
import com.ranae.ecommmarket.repository.ServiceRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EcommMarketApplicationUnitTests {

	//for checking products catalogue in DB
	@Autowired
	ServiceRepository productRepository;

	//for mocking dao
	@Mock
	ServiceRepository dataServiceMock;

	@InjectMocks
	ProductBusiness productBusiness;

	protected List<Product> prodList ;

	@Before
	public void setupTestData() {
		prodList = new ArrayList<Product>();
		Product prod1 = new Product();
		prod1.setId(1);
		prod1.setName("Avengers T-shirt");
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("brand1");
		prod1.setBrand(brand);
		ProductType type = new ProductType();
		type.setName("shirt");
		type.setId(1);
		prod1.setType(type);
		prod1.setPrice(200.50);
		prod1.setColor("blue");
		prod1.setSize(42);
		prod1.setAvailableCount(500);
		Supplier supplier = new Supplier();
		supplier.setId(1);
		supplier.setName("Marvel");
		prod1.setSupplier(supplier);

		Product prod2 = new Product();
		prod2.setId(2);
		prod2.setName("Justice League T-shirt");
		Brand brand1 = new Brand();
		brand1.setId(1);
		brand1.setName("brand2");
		prod2.setBrand(brand1);
		ProductType type1 = new ProductType();
		type1.setName("shirt2");
		type1.setId(1);
		prod2.setType(type1);
		prod2.setPrice(240.50);
		prod2.setColor("white");
		prod2.setSize(40);
		prod2.setAvailableCount(900);
		Supplier supplier1 = new Supplier();
		supplier1.setId(1);
		supplier1.setName("DC");
		prod2.setSupplier(supplier1);

		prodList.add(prod1);
		prodList.add(prod2);
	}

	/**
	 * DB data test
	 */
	@Test
	public void testProductsListNotEmpty() {
		List<Product> l = productRepository.getAllProducts(1);
		Assert.assertTrue(l.size() > 0);
	}


	/**
	 * business layer test with mock DB data
	 */
	@Test
	public void testGetAllProductsMock(){
		when(dataServiceMock.getAllProducts(1)).thenReturn(prodList);
		assertEquals(2, productBusiness.getAllProducts(1).size());
	}

	/**
	 * business layer test with mock DB data
	 */
    @Test
	public void testGetProductsByBrand(){
		List<Product> prodListForBrand = new ArrayList<Product>();
		Product prod1 = new Product();
		prod1.setId(3);
		prod1.setName("Black Cap");
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("Nike");
		prod1.setBrand(brand);
		ProductType type = new ProductType();
		type.setName("cap");
		type.setId(1);
		prod1.setType(type);
		prod1.setPrice(500.0);
		prod1.setColor("black");
		prod1.setSize(16);
		prod1.setAvailableCount(600);
		Supplier supplier = new Supplier();
		supplier.setId(1);
		supplier.setName("ABCRetails");
		prod1.setSupplier(supplier);
		
		prodListForBrand.add(prod1);
		when(dataServiceMock.getProductsByBrand(anyString(), anyInt())).thenReturn(prodListForBrand);
		assertTrue(!CollectionUtils.isEmpty(productBusiness.getProductsByBrand("Nike",1)));
		assertTrue(productBusiness.getProductsByBrand("Nike", 1).size()==1);
		assertEquals("Black Cap",productBusiness.getProductsByBrand("Nike", 1).get(0).getName());
	}

	/**
	 * business layer test with mock DB data
	 */
	@Test
	public void testGetProductBySku(){
		Product prod1 = new Product();
		prod1.setId(4);
		prod1.setName("Nike shoe");
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("Nike shoe");
		prod1.setBrand(brand);
		ProductType type = new ProductType();
		type.setName("shoe");
		type.setId(1);
		prod1.setType(type);
		prod1.setPrice(655.0);
		prod1.setColor("black");
		prod1.setSize(16);
		prod1.setAvailableCount(600);
		Supplier supplier = new Supplier();
		supplier.setId(1);
		supplier.setName("ABB retail");
		prod1.setSupplier(supplier);
		
		Optional<Product> product = Optional.of(prod1);
		
		when(dataServiceMock.getProductBySKU(4)).thenReturn(product);
		assertEquals("Nike shoe", productBusiness.getProductBySKU(4).get().getName());
		assertEquals("Nike", productBusiness.getProductBySKU(4).get().getBrand().getName());
		assertEquals("shoe", productBusiness.getProductBySKU(4).get().getType().getName());
		assertEquals("655.0", String.valueOf(productBusiness.getProductBySKU(4).get().getPrice()));
	}

	@Ignore
	@Test
	public void testGetProductsByTypeAndColor(){
		//TODO similar logic as above
	}

	//TODO other business layer methods tests

}
