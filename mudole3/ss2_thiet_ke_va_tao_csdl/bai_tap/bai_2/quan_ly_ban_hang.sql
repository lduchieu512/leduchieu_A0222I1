CREATE DATABASE IF NOT EXISTS quan_ly_ban_hang;
USE quan_ly_ban_hang;
DROP DATABASE quan_ly_ban_hang;

CREATE TABLE customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
customer_name VARCHAR(50),
customer_age DATE
);

CREATE TABLE `order`(
order_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
order_data VARCHAR(50),
order_total_price DOUBLE,
FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

CREATE TABLE order_detail(
order_id INT,
product_id INT,
order_QTY VARCHAR(50),
FOREIGN KEY (order_id) REFERENCES `order` (order_id),
FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE TABLE product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50),
product_price DOUBLE
);






