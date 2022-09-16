create database bai_thi_cu1;
-- drop database bai_thi_cu1;
use bai_thi_cu1;
-- drop table product;
CREATE TABLE `bai_thi_cu1`.`category` (
id int not null auto_increment primary key,
`name` varchar(45) not null
);
CREATE TABLE `bai_thi_cu1`.`product` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `quantity` INT NULL,
  `color` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  id_category int ,
  foreign key (id_category) references category(id),
  PRIMARY KEY (`id`));
INSERT INTO `bai_thi_cu1`.`category` (`id`, `name`) VALUES ('1', 'Phone');
INSERT INTO `bai_thi_cu1`.`category` (`id`, `name`) VALUES ('2', 'Television');
INSERT INTO `bai_thi_cu1`.`category` (`id`, `name`) VALUES ('3', 'Bicycle');
INSERT INTO `bai_thi_cu1`.`category` (`id`, `name`) VALUES ('4', 'Car');

INSERT INTO `bai_thi_cu1`.`product` (`id`, `name`, `price`, `quantity`, `color` ) VALUES ('1', 'IPhone11', '799.0', '12', 'Green' );
INSERT INTO `bai_thi_cu1`.`product` (`id`, `name`, `price`, `quantity`, `color` ) VALUES ('2', 'IPhone 11', '1100.0', '12', 'Green,Black,White');
INSERT INTO `bai_thi_cu1`.`product` (`id`, `name`, `price`, `quantity`, `color` ) VALUES ('3', 'IPhone X', '749.0', '13', 'Coral,Black,Blue');
INSERT INTO `bai_thi_cu1`.`product` (`id`, `name`, `price`, `quantity`, `color` ) VALUES ('4', 'Smart TV man hinh cong', '1000000', '5', 'Black');
INSERT INTO `bai_thi_cu1`.`product` (`id`, `name`, `price`, `quantity`, `color`) VALUES ('5', 'SAMSUNG GALAXY S10 E', '420.0', '10', 'Purple,Yellow');
-- delete from product where id = 10;
-- select * from product order by `name`;
SELECT * FROM product p 
join category c
on p.id_category=c.id;
select * from product;
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');
INSERT INTO `bai_thi_cu1`.`product` ( `name`, `price`, `quantity`, `color`,`description`, `id_category`) values('hiu','120','12','blue','','3');


select * from product p where p.id =1;
select id,name,price,quantity,color,description,id_category from product where id =1;
update product set name = "hieu13",price= "2003",quantity= "3",color= "blue13",description= "13", id_category ="1" where id = 13;



