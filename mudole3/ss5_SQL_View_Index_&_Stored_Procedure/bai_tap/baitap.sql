create database basic;
use basic;
-- drop database basic;

create table product(
id int auto_increment primary key,
product_code varchar(45),
product_name  varchar(45),
product_price double,
product_amount int,
product_description varchar(200),
product_status varchar(45)
);

insert into product (product_code,product_name,product_price,product_amount,product_description,product_status) values
(1,'iphone',10,100,'for sale','used'),
(2,'samsung',20,200,'for sale','new'),
(3,'xiaomi',30,300,'for sale','new'),
(4,'bphone',40,400,'for sale','used');

-- buoc 3
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create  index i_product_code on product(product_code);
alter table product add INDEX idx_code(`product_code`);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create unique index i_product_nam_price on product(product_name,product_price);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain  select * from product WHERE product_code = 1; 
-- So sánh câu truy vấn trước và sau khi tạo index
explain  select * from product WHERE product_name = 'xiaomi' and product_price = 30; 

-- b4
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, 
-- productStatus từ bảng products.
create view product_view as 
select product_code, product_name, product_price,product_status 
from product;
select * from product_view;
-- Tiến hành sửa đổi view
create or replace view product_view as
select product_code,product_name,product_price,product_amount,product_description,product_status 
from product
where product_name ='iphone';
-- Tiến hành xoá view
drop view product_view;

-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter // 
create procedure findAllProduct()
begin 
	select * from product;
end //
delimiter ;
call findAllProduct();

-- Tạo store procedure thêm một sản phẩm mới
delimiter // 
create procedure add_product
( in p_code varchar(45),
  in p_name varchar(45),
  in p_price double)
begin 
	insert into product( product_code,product_name,product_price)
    value
    ( product_code,product_name,product_price);
end //
delimiter ;
call add_product('7','nokia',121);
-- drop procedure add_product;

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit
( p_id int,
 p_code varchar(45),
p_name  varchar(45),
p_price double,
p_amount int,
p_description varchar(200),
p_status varchar(45)
 )
begin 
	update  product 
    set product_code = p_code,product_name = p_name,product_price = p_price,product_amount = p_amount,product_description=p_description,product_status =p_status
    where id = p_id;
end //
delimiter ;

call edit(1,'8','dell',80,880,'sale','new');
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_p_id
(in p_id int)
begin 
	delete from product 
    where id=p_id;
end //
delimiter ;

call delete_p_id(2);
select * from product ;


