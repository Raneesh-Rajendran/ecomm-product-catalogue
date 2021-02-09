# ecomm-product-catalogue

ecomm-product-catalogue-back-end implementation

This is a fully functional spring-boot web service with pagination (20 results at a time) and data caching (conditional and time interval, 2 hrs). It uses Spring Data JPA and H2 embedded RDMS database.

Information
URLS exposed >>

GET : /products/pageNum/{pageNum} : Api for fetching all products with details
GET : /products/brand/{brand}/pageNum/{pageNum} : Api for fetching products details by brand
GET : /products/price/min/{min}/max/{max}/pageNum/{pageNum} : Api for fetching products details by price range
GET : /products/{sku} : Api for fetching product details by SKU
GET : /products/seller/{supplier} : Api for fetching product count by SKU (product id) and seller
GET : /products/type/{type}/size/{size}/pageNum/{pageNum} : Api for fetching products details by type and size
GET : /products/type/{type}/color/{color}/pageNum/{pageNum} : Api for fetching products details by type and color \

Prerequisites
java 8+ 
maven

In the root dir run -> 
mvn spring-boot:run

Running the tests
In the root dir run ->
mvn test

You will be able to access the application through:
http://localhost:8080/products/<api-relative-url>
  
URL to access embedded H2 Database console :
http://localhost:8080/h2-console/
username: admin
password : admin

H2 DB data setup file :
src/main/resources/data.sql

Sample Product json response :

[
    {
        "id": 1,
        "name": "Adidas Shirt-1",
        "brand": {
            "id": 1,
            "name": "Adidas"
        },
        "type": {
            "id": 1,
            "name": "Shirt"
        },
        "supplier": {
            "id": 1,
            "name": "MNSuppliers"
        },
        "availableCount": 1000,
        "price": 500.5,
        "size": 40,
        "color": "Green"
    },
    {
        "id": 2,
        "name": "Nike Cap-1",
        "brand": {
            "id": 2,
            "name": "Nike"
        },
        "type": {
            "id": 2,
            "name": "Cap"
        },
        "supplier": {
            "id": 2,
            "name": "ROSRetail"
        },
        "availableCount": 5000,
        "price": 200.25,
        "size": 36,
        "color": "Yellow"
    }
]
  

Author
Raneesh Rajendran - - https://github.com/raneesh-rajendran
