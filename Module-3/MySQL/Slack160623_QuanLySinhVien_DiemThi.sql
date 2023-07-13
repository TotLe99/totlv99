create database slack160623StudentTest;
use slack160623StudentTest;

create table Test(
testID int not null auto_increment primary key,
Name varchar(20)
);

create table Student(
RN int not null auto_increment primary key,
Name varchar(20),
Age tinyint,
Status varchar(20)
);

create table StudentTest(
RN int, foreign key (RN) references Student (RN),
TestID int, foreign key (TestID) references Test (TestID),
Date datetime,
Mark float
);

insert into Student(name, Age) values ('Nguyen Hong Ha', 20), ('Truong Ngoc Anh', 30),
('Tuan Minh', 25), ('Dan Truong', 22);
insert into Test(name) values('EPC'),('DWMX'),('SQL1'),('SQL2');
insert into StudentTest(RN, TestID, Date, Mark)
value (1,1,'2006-7-17',8),(1,2,'2006-7-18',5),(1,3,'2006-7-19',7),(2,1,'2006-7-17',7),
(2,2,'2006-7-18',4),(2,3,'2006-7-19',2),(3,1,'2006-7-17',10),(3,3,'2006-7-18',1);

-- Cau 2 Danh sach hoc vien tham gia
select s.name, t.name, st.mark, st.date from student s
left join studenttest st on st.rn = s.rn
left join test t on t.testid = st.testid
where st.mark is not null;

-- Cau 3 Danh sach hoc vien khong tham gia
select s.rn, s.name, s.age from student s
left join studenttest st on st.rn = s.rn
where st.mark is null;

-- Cau 4 Hoc vien va mon phai thi lai (diem nho hon 5)
select s.name, t.name, st.mark, st.date from student s
left join studenttest st on st.rn = s.rn
left join test t on t.testid = st.testid
where st.mark < 5;

-- Cau 5 Hoc vien va diem trung binh (Average) da thi
select s.name, avg(mark) as Average from student s
left join studenttest st on st.rn = s.rn
where st.mark is not null
group by s.name
order by Average desc;

-- Cau 6 Hoc vien va diem trung binh cao nhat
select s.name, avg(mark) as Average from student s
left join studenttest st on st.rn = s.rn
group by s.name
order by Average desc
limit 1;

-- Cau 7 Hiển thị điểm thi cao nhất của từng môn học. Danh sách phải được sắp xếp theo tên môn học tăng dần ASCII
select t.name, max(st.mark) as 'Max Mark' from test t
left join studenttest st on st.testid = t.testid
where st.mark is not null
group by t.name
order by t.name;

-- Cau 8 Hiển thị danh sách tất cả các học viên và môn học 
-- mà các học viên đó đã thi nếu học viên chưa thi môn nào thì phần tên môn học để Null
select s.name, t.name from student s
left join studenttest st on st.rn = s.rn
left join test t on t.testid = st.testid;

-- Cau 9 Sửa (Update) tuổi của tất cả các học viên mỗi người lên một tuổi.
update student s set age = age + 1 where rn > 0;

-- Cau 10 Thêm trường tên là Status có kiểu Varchar(10) vào bảng Student.
alter table student add Status varchar(10);

-- Cau 11 Cập nhật(Update) trường Status sao cho những học viên nhỏ hơn 30 tuổi sẽ nhận giá trị ‘Young’,
-- trường hợp còn lại nhận giá trị ‘Old’
update student set status =
case when age < 30 then 'Young' else 'Old' end
where rn > 0;
select * from student;

-- Cau 12 Tạo view tên là vwStudentTestList hiển thị danh sách học viên và điểm thi,
-- dánh sách phải sắp xếp tăng dần theo ngày thi.
create view vwStudentTestList as
select s.name as 'Student Name', t.name as 'Test Name', st.mark, st.date from student s
left join studenttest st on st.rn = s.rn
left join test t on t.testid = st.testid
where st.date
order by st.date;

-- Cau 13 Tạo một trigger tên là tgSetStatus sao cho khi sửa tuổi của học viên thi trigger này 
-- sẽ tự động cập nhật status.
delimiter //
create trigger tg_status before update on student for each row
begin
update student set status =
case when age < 30 then 'Young' else 'Old' end where rn = new.rn and rn > 0;
end//
delimiter ;

/** Cau 14 Tạo một stored procedure tên là spViewStatus, stored procedure này nhận vào 2 tham số:
	-Tham số thứ nhất là tên học viên					
	-Tham số thứ 2 là tên môn học
Nếu tên học viên hoặc tên môn học không tìm thây trong cơ sở dữ liệu thì hiện ra màn hình thông báo: ‘Khong tim thay’
Trường hợp còn lại thi hiển thị trạng thái của học viên đó với môn học đó theo quy tắc sau:
	-Hiển thị ‘Chua thi’ nếu học viên đó chưa thi môn đó
	-Hiển thị ‘Do’ nếu đã thi rồi và điểm lơn hơn hoặc bằng 5
	-Hiển thị ‘Trượt’ nếu đã thi rồi và điểm thi nhỏ hơn 5 **/
    
    delimiter //
    create procedure spViewStatus(in p_studentname varchar(20), in p_testname varchar(20))
    begin
    declare student_id int;
    declare test_id int;
    declare student_status varchar(20);
    declare studenttest_mark float;
    select rn into student_id from student where name = p_studentname;
    select testid into test_id from test where name = p_testname;
    
    if student_id is null or test_id is null then 
		select 'Khong tim thay';
    else
		select status into student_status from student where rn = student_id;
		select mark into studenttest_mark from studenttest where rn = student_id and testid = test_id;
    
		if studenttest_mark is null then
			select 'Chua thi';
		elseif studenttest_mark >= 5 then
			select 'Do';
		else
			select 'Truot';
		end if;
	end if;
	end//
    delimiter ;
    
    
    
    
    delimiter //
    drop procedure spViewStatus//
    delimiter ;
    call spViewStatus('Nguyen Hong Ha', 'SQL1');
