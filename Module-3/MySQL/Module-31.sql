use date130623quanlysinhvien;

insert into Class values(1, 'A1', '2008-12-20', 1);
insert into Class values(2, 'A2', '2008-12-22', 1);
insert into Class values(3, 'B3', current_date, 0);

insert into student(StudentName, Address, Phone, Status, classID)
values('Hung', 'Ha Noi', '098753211', 1, 1);
insert into student(StudentName, Address,Phone, Status, ClassId)
 values('Tot','Ha Noi','012345678', 1, 1);
insert into student(StudentName, Address, Phone, Status, ClassId)
 values('Toan','Ha Noi','034567890', 0, 2);
 
 insert into subject values(1, 'C', 5, 1);
 insert into subject values(2, 'HDJ', 6, 1);
 insert into subject values(3, 'RDMS', 10, 1);
 
 INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);