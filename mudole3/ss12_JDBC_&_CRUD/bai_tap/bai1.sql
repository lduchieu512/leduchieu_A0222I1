create database if not exists p1_ss12;
use p1_ss12;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

-- tạo sp tìm kiếm theo 3 trường
delimiter //
create procedure search(in p_name varchar(50), in p_account varchar(50), in p_class_id varchar(50))
begin
select * from student where name like concat('%',p_name,'%') and account like concat('%',p_account,'%') and class_id like concat('%',p_class_id,'%');
end //
delimiter ;
select * from users