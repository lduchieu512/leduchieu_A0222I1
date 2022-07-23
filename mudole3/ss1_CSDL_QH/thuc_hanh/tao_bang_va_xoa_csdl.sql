CREATE DATABASE my_database1;
use my_database1;
DROP DATABASE `my_database1`;
CREATE TABLE `my_database1`.`student` (
  `id` INT ,
  `name` VARCHAR(45) ,
  `age` INT ,
  `country` VARCHAR(45),
  primary key (`id`));
DROP TABLE student;
