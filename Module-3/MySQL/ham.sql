use date130623quanlysinhvien;

select address, count(studentid) as 'Số lượng học viên'
from student
group by address;

select s.studentid, s.studentname, avg(Mark)
from student s join mark m on s.StudentID = m.StudentID
group by s.studentid;

select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.studentid = m.studentid
group by s.studentid, s.studentname
having avg(mark) > 15;

select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.studentid = m.studentid
group by s.studentid, s.studentname
having avg(mark) >= all (select avg(mark)
from mark group by mark.studentid);

select sb.* from subject sb
group by sb.SubID
having max(Credit) >= (select max(Credit)
from subject sb);

select sb.* from subject sb
group by sb.SubID
having min(Credit) <= (select min(Credit)
from subject sb);

select s.*, avg(mark) as 'diemtrungbinh' from student s
left join mark m on m.studentid = s.studentid
group by s.StudentID
order by avg(mark) desc;

select s.*, avg(mark) as diemtrungbinh from student s
left join mark m on s.StudentID = m.StudentID
group by s.StudentID
order by diemtrungbinh desc
limit 1;

select s.*, avg(mark) as DiemTrungBinh from student s
left join mark m on m.studentid = s.studentid
group by s.studentid
order by diemtrungbinh
limit 1;