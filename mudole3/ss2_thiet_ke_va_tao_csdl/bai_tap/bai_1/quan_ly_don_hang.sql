CREATE DATABASE quan_ly_don_hang;
USE quan_ly_don_hang;
DROP DATABASE quan_ly_don_hang;
CREATE TABLE phieu_xuat(
id INT PRIMARY KEY AUTO_INCREMENT,
so_phieu_xuat VARCHAR(45),
ngay_xuat DATETIME  
);

CREATE TABLE chi_tiet_phieu_xuat(
phieu_xuat_id INT,
vat_tu_id INT,
don_gia_phieu_xuat VARCHAR(45),
so_luong_phieu_xuat INT,
foreign key(phieu_xuat_id) references phieu_xuat(id),
FOREIGN KEY (vat_tu_id) REFERENCES vat_tu (id)
);

CREATE TABLE vat_tu(
id INT PRIMARY KEY AUTO_INCREMENT,
ma_vat_tu VARCHAR(45),
ten_vat_tu VARCHAR(45)  
);

CREATE TABLE chi_tiet_phieu_nhap(
vat_tu_id INT,
phieu_nhap_id INT,
don_gia_nhap VARCHAR(45),
so_luong_nhap INT NOT NULL,
FOREIGN KEY (vat_tu_id) REFERENCES vat_tu (id),
FOREIGN KEY (phieu_nhap_id) REFERENCES phieu_nhap (id)
);

CREATE TABLE phieu_nhap(
id INT PRIMARY KEY AUTO_INCREMENT,
so_phieu_nhap VARCHAR(45),
ngay_nhap DATETIME
);

CREATE TABLE chi_tiet_don_hang(
vat_tu_id INT,
don_dat_hang_id INT ,
FOREIGN KEY (vat_tu_id) REFERENCES vat_tu (id),
FOREIGN KEY (don_dat_hang_id) REFERENCES don_dat_hang (id)
);

CREATE TABLE don_dat_hang(
id INT PRIMARY KEY AUTO_INCREMENT,
so_dat_hang VARCHAR(45),
ngay_dat_hang DATETIME,
nha_cung_cap_id INT,
foreign key(nha_cung_cap_id) references nha_cung_cap(id)
);

CREATE TABLE nha_cung_cap(
id INT PRIMARY KEY AUTO_INCREMENT,
ma_nha_cung_cap VARCHAR(45),
ten_nha_cung_cap VARCHAR(45),
dia_chi VARCHAR(45),
so_dien_thoai INT
);




 


