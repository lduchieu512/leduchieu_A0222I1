create database can_ho;
use can_ho;
CREATE TABLE `can_ho`.`ho_khau` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `chu_ho` VARCHAR(45) NOT NULL,
  `so_luong` INT NOT NULL,
  `ngay_dk` DATE NULL,
  `dia_chi` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`id`));

CREATE TABLE `can_ho`.`member` (
  `id_member` INT NOT NULL AUTO_INCREMENT,
  `cmnn` INT NULL,
  `ho_va_ten` VARCHAR(45) NOT NULL,
  `ngay_sinh` DATE NOT NULL,
  `id_can_ho` INT NOT NULL,
   foreign key (id_can_ho) references `ho_khau` (id),
  PRIMARY KEY (`id_member`));
  INSERT INTO `can_ho`.`ho_khau` (`id`, `chu_ho`, `so_luong`, `ngay_dk`, `dia_chi`) VALUES ('1', 'le van A', '4', '2002-12-02', 'da nang');
INSERT INTO `can_ho`.`ho_khau` (`id`, `chu_ho`, `so_luong`, `ngay_dk`, `dia_chi`) VALUES ('2', 'ho van B', '5', '2012-03-12', 'hue');
INSERT INTO `can_ho`.`ho_khau` (`id`, `chu_ho`, `so_luong`, `ngay_dk`, `dia_chi`) VALUES ('3', 'nguyen van c', '3', '2019-12-01', 'ha noi');
INSERT INTO `can_ho`.`ho_khau` (`id`, `chu_ho`, `so_luong`, `ngay_dk`, `dia_chi`) VALUES ('4', 'tran duc C', '6', '1992-10-12', 'quang tri');
INSERT INTO `can_ho`.`ho_khau` (`id`, `chu_ho`, `so_luong`, `ngay_dk`, `dia_chi`) VALUES ('5', 'le trong D', '3', '1999-12-31', 'nha trang');
-- 
INSERT INTO `can_ho`.`member` (`id_member`, `cmnn`, `ho_va_ten`, `ngay_sinh`, `id_can_ho`) VALUES ('1', '201868550', 'Le Van A', '1945-12-03', '1');
INSERT INTO `can_ho`.`member` (`id_member`, `cmnn`, `ho_va_ten`, `ngay_sinh`, `id_can_ho`) VALUES ('2', '201290345', 'Nguyen Thi N', '1950-10-02', '1');
INSERT INTO `can_ho`.`member` (`id_member`, `cmnn`, `ho_va_ten`, `ngay_sinh`, `id_can_ho`) VALUES ('3', '2124778219', 'Le Thi AB', '1989-11-19', '1');
INSERT INTO `can_ho`.`member` (`id_member`, `cmnn`, `ho_va_ten`, `ngay_sinh`, `id_can_ho`) VALUES ('4', '12948124', 'Le Van DB', '1991', '1');
INSERT INTO `can_ho`.`member` (`id_member`) VALUES ('');


SELECT * FROM can_ho.ho_khau;
SELECT * FROM can_ho.member;

select id,chu_ho,so_luong,ngay_dk,dia_chi from ho_khau where id =3;

  
  




