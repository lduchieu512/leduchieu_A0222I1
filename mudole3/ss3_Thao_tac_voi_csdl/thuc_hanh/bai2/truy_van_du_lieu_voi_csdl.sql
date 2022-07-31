CREATE DATABASE quan_ly_sinh_vien_ss3_th_b2;
USE	quan_ly_sinh_vien_ss3_th_b2;
DROP DATABASE quan_ly_sinh_vien_ss3_th_b2;
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
SELECT * FROM class;
-- Thêm dữ liệu vào trong bảng Student bằng các câu lệnh insert into như sau:
INSERT INTO student (studentName,address,phone,`status`,classID)
VALUE   ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (studentName,address,`status`,classID)
VALUE	('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (studentName,address,phone,`status`,classID)
VALUE   ('Manh', 'HCM', '0123123123', 0, 2);
SELECT * FROM student WHERE `status` = TRUE;
--  Thêm dữ liệu nhanh vào trong bảng Subject:
INSERT INTO  `subject`
VALUE  (1, 'CF', 5, 1),
	   (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
SELECT * FROM `subject` WHERE credit <10 ;
--  Thêm dữ liệu vào trong bảng Mark bằng câu lệnh insert into như sau:
INSERT INTO  mark (subId,studentId,mark,examTimes)
VALUE  (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
SELECT * FROM mark;

SELECT S.studentId, S.studentName ,C.classId FROM student S JOIN class C ON S.classId = C.classID;
-- hiển thị danh sách học viên lớp A1
SELECT S.studentId ,S.studentName ,C.classId FROM student S JOIN class C ON S.classId = C.classID WHERE C.className = 'A1';
-- 
SELECT S.studentId ,S.studentName , Sub.subName , M.mark 
FROM student S JOIN mark M on S.studentId = M.studentId
				JOIN  `subject` Sub on Sub.subId = M.subId WHERE Sub.subName ='C';