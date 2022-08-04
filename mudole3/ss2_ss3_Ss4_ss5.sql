create database if not exists a0222i1;
use a0222i1;
create table class_type(
id int primary key auto_increment,
`name` varchar(50)
);

create table class(
id int auto_increment,
`name` varchar(50),
primary key(id),
class_type_id int,
foreign key(class_type_id) references class_type(id)
);

create table jame(
`account` varchar(50) primary key,
`password` varchar(50)
);

create table student(
id int primary key auto_increment,
`name` varchar(50),
 gender boolean,
 birthday date,
 email varchar(50),
 `point` float,
 `account` varchar(50),
  foreign key(`account`) references jame(`account`),
  class_id int,
  foreign key(class_id) references class(id)
);
create table instructor (
id int primary key auto_increment,
`name` varchar(50),
birthday date,
salary float
);

create table instructor_class (
 class_id int,
 instructor_id int,
 primary key(class_id,instructor_id),
 foreign key(class_id) references class(id),
 foreign key(instructor_id) references instructor(id),
 start_day date
);
-- Nhập thông tin cho bảng 
insert into class_type (name) values ('full time'), ('part time'),('orther');

insert into class (name,class_type_id) values ('c1121g1',1), ('c1221g1',1),('a0821i1',2),('a0921i1',2);

insert into jame(`account`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');

insert into jame(`account`,`password`)
 values('anv','12345'),('bnv','12345');

 
insert into instructor(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
insert into instructor(`name`,birthday, salary)
 values('tran van nam','1989-12-12',100);

 
 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');

 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen van a','1981-12-12',1,8,null,'anv'),('tran van b','1981-12-12',1,5,null,'bnv');
 
select * from class_type;
select* from class;
select* from student;
select* from jame;
select* from instructor;
select * from student;
select * from instructor_class;

 insert into instructor_class(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);

-- ss3 thao tác với csdl

-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
select s.id, s.name, s.birthday,c.name as class_name
from student s 
inner join class c  
on s.class_id = c.id;


-- 2.1 Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học.
select s.id, s.name, s.birthday,c.name as class_name
from student s 
left join class c  
on s.class_id = c.id;

select s.id, s.name, s.birthday,c.name as class_name
from student s 
right join class c  
on s.class_id = c.id;

-- 2.2 join 3 bảng lấy thêm thông tin tên loại lớp

select *
from student s 
inner join class c  
on s.class_id = c.id
inner join class_type ct
on c.class_type_id= ct.id
;

-- 4.1 Lấy thông tin của các học viên tên 'nguyen minh hai'.
select *
from student
where name ='nguyen minh hai';

-- 4.2 Lấy thông tin của các học viên tên 'hai' hoặc 'huynh’.
select *
from student
where name like '% hai' or name like'% huynh';
-- 5.1 Lấy ra các học viên có điểm lớn hơn 5 .
select *
from student
where point>5;
-- 5.2 lấy ra thông tin các học viên có điểm 4,6,8
select *
from student
where point in (4,6,8);
-- 6. Lấy ra học viên có họ là “nguyen”
select *
from student
where name like 'nguyen %';
-- 7. Thông kế số lượng học sinh theo từng loại điểm.
 select s.point as loai_diem, count(s.point) as sl
 from student s
 group by s.point;
-- 8 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5

 select s.point as loai_diem, count(s.point) as sl
 from student s
 where s.point>5
 group by s.point;
 
-- 9. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
 select s.point as loai_diem, count(s.point) as sl
 from student s
 where s.point>5
 group by s.point
 having sl>=2;
  select*
 from student s
 having s.point>5;
 
-- 10. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên học viên theo point,
-- nếu point bằng nhau thì sắp xếp theo tên.
select * 
from student s
join class c
on s.class_id = c.id
where c.name = 'c1121g1'
order by s.point asc, s.name asc;

-- thêm phần Regexp - lấy ra học viên có tên là bắt đầu 'h'
select * 
from student s
where s.name regexp '\\w+\\sh[a-z]+$';

select * from class_type;
select* from class;
select* from jame;
select * from student;
select* from instructor;
select * from instructor_class;

-- bài 4: sử dụng các hàm thông dụng

-- 1 đếm số học viên toàn trung tâm
select count(*) as so_luong
from student;

-- 2 Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp
select c.name as class_name, count(s.class_id) as so_luong
from student s 
 join class c 
on s.class_id = c.id
group by c.id;

-- 3. Hiện thị điểm lớn nhất của mỗi các lớp
select c.name as class_name, max(s.point )as diem_max
from student s 
 join class c 
on s.class_id = c.id
group by c.id;

-- 4	 Tình điểm trung bình  của từng lớp 
select c.name as class_name, avg(s.point )as diem_tb
from student s 
 join class c 
on s.class_id = c.id
group by c.id;

-- 5 Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym.
select s.name as ten, s.birthday as ngay_sinh
from student s
union all
select i.name, i.birthday
from instructor i;
-- hỗ trợ full join
select *
from student s 
 left join class c 
on s.class_id = c.id
union
select *
from student s 
 right join class c 
on s.class_id = c.id;

-- 6 Lấy ra 3 học viên có điểm cao nhất của trung tâm.->
select s.name, s.point
from student s
order by s.point desc
limit 3,3;

 -- 7. Lấy ra các học viên có điểm số là cao nhất của trung tâm.
 -- dùng subquery
select * 
 from student s
 where s.point = (select max(s.point) from student s);
 
-- 8 tìm  những gv chưa từng tham gia giảng dạy;
-- dùng join
select i.name, ic.instructor_id
from instructor i 
left join instructor_class ic
on i.id = ic.instructor_id
where ic.instructor_id is null;
-- dùng truy vấn con với in
select * 
from instructor i
where i.id not in 
(select ic.instructor_id 
from instructor_class ic
group by ic.instructor_id);

-- dùng truy vấn con với exist
select * 
from instructor i
where not exists (select *
from instructor_class ic
where i.id =ic.instructor_id);

select* from instructor;
select * from instructor_class;
 

-- bài 5: index và view
explain select * 
from customers
where city = 'lyon';


-- tạo index
create index i_city on customers(city);
-- xóa index
drop index i_city on customers;
-- tạo index trên cột country
alter table customers add index i_country(country);
alter table customers drop index i_country;
-- tạo view
create view w_student as
select s.id,s.name as name_student, s.point,c.id as class_id, c.name as class_name
from student s
join class c 
on s.class_id = c.id;
--
select * 
from w_student;
-- stored procedure

-- tạo một sp_ để lấy danh sách student
delimiter $$
create procedure  sp_get_all_student()
begin
select * from student;
end $$
delimiter ;

call sp_get_all_student();
-- sp_ có tham số in: lấy ra thông tin của học viên theo id
delimiter //
create procedure  sp_find_by_id(in p_id int)
begin
select * from student where id =p_id;
end //
delimiter ;
-- gọi sp
call sp_find_by_id(10);

-- đếm số lượng học viên trong bảng student
delimiter //
create procedure  count_student(out count int)
begin
select count(id) into count from student;
end //
delimiter ;

call count_student(@so_luong);
select @so_luong;

select * from class_type;
select* from class;
select* from jame;
select * from student;
select* from instructor;
select * from instructor_class;

-- Function
-- tạo function xếp loại dựa trên điểm
delimiter $$
create function xep_loai(p_point int)
returns varchar(50)
deterministic
begin
declare loai varchar(20);
if p_point>=8 then
set loai ="giỏi";
elseif p_point >=7 then
set loai ="Khá";
elseif p_point>=5 then
set loai ="trung binh";
else 
set loai ="Yếu";
end if;
return loai;
end $$
delimiter ;
-- sử dụng function xep_loai(point)
select *,xep_loai(point) as xep_loai from student;

-- trigger
-- 2. Tạo trigger tự động tạo tài khoản jame mới trước khi thêm một sinh viên
-- + Tài khoản jame được tạo dựa trên username là email và password mặc định "123"
select* from jame;
select * from student;
 insert into student(`name`,birthday, gender,email,`point`, class_id,`account`) 
 values ('hieu','1981-12-12',1,'hieudeptrai@gmail.com',8,1,'hieudeptrai@gmail.com');

drop trigger auto_create_jame;
delimiter $$
create trigger auto_create_jame
 before insert on student
for each row
begin
insert into jame(`account`,`password`)values(new.email,'123');
end $$
delimiter ;












