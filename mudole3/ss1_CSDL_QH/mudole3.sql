CREATE DATABASE if not exists mudole3;
use mudole3;
CREATE TABLE student(
id int, 
`name` varchar(50),
birthday date
);
-- them moi
insert into student
values(1,'hiu','2002-10-05');
insert into student(id,name,birthday)
values(2,'tai','2002-12-30'),
		(3,'huy','2000-8-15');
-- lay thong tin
select s.id, s.`name`
from student s;
select * from student;
-- ------------------thay doi thong tin
update student 
set name = 'hieule', birthday='2002-10-10'
where id =1;
-- xoa thong tin record
delete from student
where name ='tai';
-- thêm mới 1 trường
alter table student 
add column `point` int;
-- xoá bảng 
drop table student;
-- xoá csdl
drop database mudole3;




