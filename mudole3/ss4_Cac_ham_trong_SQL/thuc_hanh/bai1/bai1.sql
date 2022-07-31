use quan_ly_sinh_vien_ss3_th_b2;

select address , count(studentId) as 'Số lượng học viên'
FROM student 
group by address;

select s.studentId,s.studentName, avg(mark)
from student s join mark m on s.studentId = m.studentId
group by s.studentId,s.studentName
having avg(mark) >15;

select s.studentId,s.studentName, avg(mark)
from student s join mark m on s.studentId = m.studentId
group by s.studentId,s.studentName
having avg(mark) >=all (select avg(mark) from mark group by mark.studentId);
