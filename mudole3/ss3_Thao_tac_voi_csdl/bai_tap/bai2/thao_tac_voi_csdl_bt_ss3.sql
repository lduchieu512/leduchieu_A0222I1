CREATE DATABASE IF NOT EXISTS quan_ly_ban_hang_bt_ss3;
USE quan_ly_ban_hang_bt_ss3;
DROP DATABASE quan_ly_ban_hang_bt_ss3;

CREATE TABLE customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
customer_name VARCHAR(50),
customer_age INT
);

CREATE TABLE `order`(
order_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
order_data VARCHAR(50),
order_total_price DOUBLE,
FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

CREATE TABLE product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50),
product_price DOUBLE
);

CREATE TABLE order_detail(
order_id INT,
product_id INT,
order_QTY VARCHAR(50),
FOREIGN KEY (order_id) REFERENCES `order` (order_id),
FOREIGN KEY (product_id) REFERENCES product (product_id)
);


INSERT INTO  customer
VALUE(1,'Minh Quan',10),
	(2,'Ngoc Oanh',20),
    (3,'Hong Ha',50);
    
INSERT INTO  `order` (order_id,customer_id,order_data)
VALUE(1,1,'3-21-2006'),
	(2,2,'3-23-2006'),
	(3,1,'3-16-2006');
    
INSERT INTO  product
VALUE (1,'May Giat',3),
	(2,'Tu Lanh',5),
	(3,'Dieu Hoa',7),
	(4,'Quat',1),
	(5,'Bep Dien',2);
    
INSERT INTO  order_detail (order_id,product_id,order_QTY)
VALUE (1,1,3),
	(1,3,7),
    (1,4,2),
    (2,1,1),
    (3,1,8),
    (2,5,4),
    (2,3,3);
    
SELECT * FROM  customer;
SELECT * FROM  product;
SELECT * FROM  order_detail;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT * FROM  `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT C.customer_name, P.product_name , count(P.product_name ) FROM customer C
JOIN `order` O ON C.customer_id = O.customer_id 
JOIN order_detail OD ON C.customer_id = OD.order_id
JOIN product P ON OD.product_id = P.product_id
group by P.product_name ;
--
-- SELECT * FROM customer C 
-- JOIN `order` O ON C.customer_id = O.customer_id 
-- JOIN order_detail OD ON O.order_id = OD.order_id
-- JOIN product P ON OD.product_id = P.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT C.customer_name  FROM customer C 
LEFT JOIN `order` O on O.customer_id = C.customer_id WHERE O.order_id is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng
-- giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT O.order_id as 'CODE', O.order_data as 'date' ,sum(P.product_price*OD.order_QTY) as 'total' FROM `order` O
JOIN order_detail OD on O.order_id = OD.order_id
JOIN product P on P.product_id = OD.product_id
GROUP BY O.order_id ;