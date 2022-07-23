create database bt_student_management;
use bt_student_management;
drop table class;
create table class(
id int,
`name` varchar(50),
age year,
class varchar(10)
);
create table teacher(
id int,
`name` varchar(50),
age year,
positions varchar(10)
);

