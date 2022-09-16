create database bai_thi_mudole3;
use bai_thi_mudole3;

CREATE TABLE `bai_thi_mudole3`.`trang_thai` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `loai_trang_thai` VARCHAR(45) NOT NULL,
  
  PRIMARY KEY (`id`));
  CREATE TABLE `bai_thi_mudole3`.`van_phong` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `loai_van_phong` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `bai_thi_mudole3`.`quan_ly_mat_bang` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ma_mat_bang` VARCHAR(20) NOT NULL,
  `dien_tich` DOUBLE NOT NULL,
  `tang` INT NOT NULL,
  `mo_ta` VARCHAR(200) NULL,
  `gia_cho_thue` INT NOT NULL,
  `ngay_bat_dau` DATE NOT NULL,
  `ngay_ket_thuc` DATE NOT NULL,
    `id_trang_thai` INT NOT NULL,
  `id_van_phong` INT NOT NULL,
  foreign key (id_van_phong) references `van_phong` (id),
  foreign key (id_trang_thai) references `trang_thai` (id),
  PRIMARY KEY (`id`));

INSERT INTO `bai_thi_mudole3`.`van_phong` (`id`, `loai_van_phong`) VALUES ('1', 'Văn phòng chia sẻ');
INSERT INTO `bai_thi_mudole3`.`van_phong` (`id`, `loai_van_phong`) VALUES ('2', 'Văn phòng trọn gói');

INSERT INTO `bai_thi_mudole3`.`trang_thai` (`id`, `loai_trang_thai`) VALUES ('1', 'Trống ');
INSERT INTO `bai_thi_mudole3`.`trang_thai` (`id`, `loai_trang_thai`) VALUES ('2', 'Hạ tầng');
INSERT INTO `bai_thi_mudole3`.`trang_thai` (`id`, `loai_trang_thai`) VALUES ('3', 'Đầy đủ');

INSERT INTO `bai_thi_mudole3`.`quan_ly_mat_bang` (`id`, `ma_mat_bang`, `dien_tich`, `tang`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`, `id_trang_thai`, `id_van_phong`) VALUES ('1', 'MB001', '100', '2', '2000000', '2021-11-25', '2022-11-25', '1', '1');
INSERT INTO `bai_thi_mudole3`.`quan_ly_mat_bang` (`id`, `ma_mat_bang`, `dien_tich`, `tang`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`, `id_trang_thai`, `id_van_phong`) VALUES ('2', 'MB002', '240', '5', '12000000', '2021-10-03', '2022-10-03', '2', '2');
INSERT INTO `bai_thi_mudole3`.`quan_ly_mat_bang` (`id`, `ma_mat_bang`, `dien_tich`, `tang`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`, `id_trang_thai`, `id_van_phong`) VALUES ('3', 'MB003', '280', '2', '10000000', '2020-09-12', '2022-12-20', '3', '1');

SELECT q.`id`, q.`ma_mat_bang`, q.`dien_tich`, q.`tang`, q.`gia_cho_thue`, 
q.`ngay_bat_dau`, q.`ngay_ket_thuc`, t.`id`,t.`loai_trang_thai`, v.`id`,v.`loai_van_phong` FROM quan_ly_mat_bang q join van_phong v 
join trang_thai t on q.`id_van_phong`=v.`id` and q.`id_trang_thai`=t.`id`;

select `id`, `ma_mat_bang`, `dien_tich`, `tang`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`, `id_trang_thai`, `id_van_phong` from quan_ly_mat_bang where id =1;
SELECT * FROM quan_ly_mat_bang q join van_phong v join trang_thai t on q.`id_van_phong`=v.`id` and q.`id_trang_thai`=t.`id`;
delete from quan_ly_mat_bang where id = 4;
SELECT * FROM quan_ly_mat_bang q join van_phong v join trang_thai t on q.`id_van_phong`=v.`id` and q.`id_trang_thai`=t.`id`;
UPDATE `bai_thi_mudole3`.`quan_ly_mat_bang` SET `ma_mat_bang` ='mb1515', `dien_tich` = '5151', `tang` = '5',`mo_ta`='5151', `gia_cho_thue` = '151', `ngay_bat_dau` =' 2022-09-12', `ngay_ket_thuc` = '2025-05-05', `id_trang_thai` = '1', `id_van_phong` = '1' WHERE `id` = 5;

