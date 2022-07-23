CREATE DATABASE quan_ly_sinh_vien;
USE	quan_ly_sinh_vien;
DROP DATABASE quan_ly_sinh_vien;
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


