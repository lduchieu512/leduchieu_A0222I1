-- Tạo View có tên customer_views truy vấn dữ liệu từ bảng customers để lấy các dữ liệu: customerNumber, customerName, phone bằng câu lệnh SELECT:
create view customer_views as 
select customerNumber ,customerName,phone  
from customers;

select * from customer_views;

create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';

drop view customer_views;


