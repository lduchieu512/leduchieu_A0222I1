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


-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select s.subName as 'subject name', max(s.credit) as credit 
from `subject` s; 
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.subName as 'subject name',max(m.mark) 
from `subject` sub join mark m on m.subId = sub.subId;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.studentName, s.address,s.phone ,avg(m.mark)
 from student s
 join mark m on s.studentId = m.studentId
 group by s.studentId
 order by avg(m.mark)desc;

