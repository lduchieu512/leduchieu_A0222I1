CREATE DATABASE quan_ly_sinh_vien_ss3_bt;
USE	quan_ly_sinh_vien_ss3_bt;
DROP DATABASE quan_ly_sinh_vien_ss3_bt;
CREATE TABLE class(
classID INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
className VARCHAR(60) NOT NULL,
classDate Datetime NOT NULL,
`status` Bit
);

CREATE TABLE student(
studentId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
studentName VARCHAR(30) NOT NULL,
address VARCHAR(50),
phone VARCHAR(20),
`status` Bit,
classId INT NOT NULL,
FOREIGN KEY (classId) REFERENCES class (classID)
);

CREATE TABLE `subject`(
subId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
subName VARCHAR(30) NOT NULL,
credit TINYINT NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
`status` BIT  DEFAULT 1
);

CREATE TABLE mark(
    markId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subId     INT NOT NULL,
    studentId INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( mark BETWEEN 0 AND 100),
    examTimes TINYINT DEFAULT 1,
    UNIQUE (subId, studentId),
    FOREIGN KEY (subId) REFERENCES Subject (subId),
    FOREIGN KEY (studentId) REFERENCES student (studentId)
);

-- Thêm lần lượt các bản ghi vào trong bảng Class như trong mô tả ở trên:
INSERT INTO class 
VALUE (1, 'A1', '2008-12-20', 1);
INSERT INTO class 
VALUE  (2, 'A2', '2008-12-22', 1);
INSERT INTO class 
VALUE      (3, 'B3', current_date, 0);
-- Thêm dữ liệu vào trong bảng Student bằng các câu lệnh insert into như sau:
INSERT INTO student (studentName,address,phone,`status`,classID)
VALUE   ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (studentName,address,`status`,classID)
VALUE	('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (studentName,address,phone,`status`,classID)
VALUE   ('Manh', 'HCM', '0123123123', 0, 2);
--  Thêm dữ liệu nhanh vào trong bảng Subject:
INSERT INTO  `subject`
VALUE  (1, 'CF', 5, 1),
	   (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
--  Thêm dữ liệu vào trong bảng Mark bằng câu lệnh insert into như sau:
INSERT INTO  mark (subId,studentId,mark,examTimes)
VALUE  (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
SELECT * FROM mark;
SELECT * FROM class;
SELECT * FROM student;
SELECT * FROM `subject`;
SELECT * FROM mark;

-- 1 Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT * FROM student WHERE studentName LIKE 'h%';
-- 2 Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
SELECT * FROM class WHERE month(classDate) =12;
-- 3 Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
SELECT * FROM `subject` WHERE credit between 3 and 5;
-- 4 Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2
UPDATE student SET classID =2 WHERE  studentName = 'Hung';
-- 5 Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
SELECT S.studentName , Sub.subName,M.mark FROM student S
JOIN mark M ON S.studentId = M.studentId
JOIN `subject` Sub ON M.subId = Sub.subId
order by M.mark desc, S.studentName;




