INSERT INTO BRAND VALUES(1, 'Adidas');
INSERT INTO BRAND VALUES(2, 'Nike');
INSERT INTO BRAND VALUES(3, 'Puma');
INSERT INTO BRAND VALUES(4, 'Reebok');



INSERT INTO PRODUCT_TYPE VALUES(1, 'Shirt');
INSERT INTO PRODUCT_TYPE VALUES(2, 'Cap');
INSERT INTO PRODUCT_TYPE VALUES(3, 'Shoe');
INSERT INTO PRODUCT_TYPE VALUES(4, 'Socks');



INSERT INTO SUPPLIER VALUES(1, 'MNSuppliers');
INSERT INTO SUPPLIER VALUES(2, 'ROSRetail');
INSERT INTO SUPPLIER VALUES(3, 'WSRetail');
INSERT INTO SUPPLIER VALUES(4, 'RRRetail');


INSERT INTO PRODUCT (ID, NAME, BRAND_ID, SUPPLIER_ID, TYPE_ID, AVAILABLE_COUNT, PRICE, SIZE, COLOR) VALUES
(1, 'Adidas Shirt-1',1,1,1,1000,500.50,40,'Green'),
(2, 'Nike Cap-1',2,2,2,5000,200.25,36,'Yellow'),
(3, 'Puma Shoe-1',3,3,3,5000,1700.25,34,'Brown'),
(4, 'Reebok Socks-1',4,4,4,5000,200.25,32,'Orange');