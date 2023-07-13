create database slack190623HoaDon;
use slack190623HoaDon;

create table khachhang(
makh int not null auto_increment primary key,
hoten varchar(22),
diachi varchar(44),
ngaysinh date,
doanhso float,
ngaydangky date
);

insert into khachhang(hoten, diachi, ngaysinh, doanhso, ngaydangky)
values ('Le Van Tot', 'HN', '1999-03-29', 2.56, '2006-01-16'),
('Nguyen Dac Tien', 'HY', '2001-06-25', 2.23, '2006-05-02'),
('Dinh Van Son', 'ND', '1998-05-05', 3.14, '2007-02-27'),
('Le Thi Thuy Linh', 'ND', '1998-06-06', 3.55, '2007-02-27'),
('Nguyen Toan', 'QN', '1998-03-30', 4.21, '2006-12-03');

create table nhanvien(
manv int not null auto_increment primary key,
hoten varchar(22),
ngayvaolam date,
sodienthoai varchar(22)
);

insert into nhanvien(hoten, ngayvaolam, sodienthoai)
values ('Le Thi Kim Dung', '2006-01-14', '0987412345'),
('Le Thi Tien', '2006-01-16', '0336499991'),
('Dinh Thi Son', '2006-01-22', '094212321');

create table sanpham(
masp int not null auto_increment primary key,
tensp varchar(22),
donvitinh int,
nuocsanxuat varchar(22),
gia double
);

insert into sanpham(tensp,donvitinh,nuocsanxuat,gia)
values ('Cocacola', '24', 'VN', 10000),
('Pepsi', '20' , 'ThaiLan', 8000),
('C2' , '25', 'VN', 7000),
('Snack', '54', 'ThaiLan', 5000),
('Aqua', '60', 'VN', 5000),
('Smooth', '15', 'ThaiLan', 8000),
('Tigerfood', 42, 'Trung Quoc', 4000),
('Mix', 24, 'Trung Quoc', 1200),
('Chick',44, 'Trung Quoc', 5000);

create table hoadon(
sohd int not null auto_increment primary key,
ngayhd date,
makh int , foreign key (makh) references khachhang (makh),
manv int, foreign key (manv) references nhanvien (manv),
trigia double
);

insert into hoadon(ngayhd, makh, manv, trigia)
values ('2006-01-16', 1, 1, 35000),
('2006-01-17', 1, 1, 30000),
('2006-05-03', 2, 2, 10000),
('2006-05-10', 2, 2, 16000),
('2007-03-01', 3, 1, 18000);

create table cthd(
sohd int, foreign key (sohd) references hoadon (sohd),
masp int, foreign key (masp) references sanpham (masp),
soluong int
);

insert into cthd(sohd, masp, soluong)
values (1, 1, 3), (1, 4, 1),
(2, 5, 6),
(3, 4, 1), (3, 5, 1),
(4, 2, 1), (4, 6, 1),
(5, 1, 1), (5, 6, 1);


-- Cau 1: Có bao nhiêu sản phẩm khác nhau được bán ra trong năm 2006.
SELECT count(temp.tensp) as 'So luong san pham ban 2006'
 from (select sanpham.tensp FROM sanpham
 JOIN cthd ON sanpham.masp = cthd.masp
 JOIN hoadon ON cthd.sohd = hoadon.sohd
WHERE YEAR(hoadon.ngayhd) = 2006
group by sanpham.masp) as temp;

-- Cau 2: Cho biết trị giá hóa đơn cao nhất, thấp nhất là bao nhiêu ?
SELECT max(hd.trigia) as 'Cao nhat', min(hd.trigia) as 'Thap nhat'
from hoadon hd;

--  Cau 3: Trị giá trung bình của tất cả các hóa đơn được bán ra trong năm 2006 là bao nhiêu?
SELECT avg(hd.trigia) as 'Tri Gia Trung Binh' from hoadon hd
where year(hd.ngayhd) = 2006;

-- Cau 4: Tính doanh thu bán hàng trong năm 2006.
SELECT sum(hd.trigia) as 'Doanh thu nam 2006' from hoadon hd
where year(hd.ngayhd) = 2006;

-- Cau 5: Tìm số hóa đơn có trị giá cao nhất trong năm 2006.
SELECT hd.sohd 'Hoa don gia tri cao nhat 2006' from hoadon hd
where year(hd.ngayhd) = 2006
order by hd.trigia desc
limit 1;

-- Cau 6: Tìm họ tên khách hàng đã mua hóa đơn có trị giá cao nhất trong năm 2006.
SELECT kh.hoten from khachhang kh
inner join hoadon hd on hd.makh = kh.makh
where year(hd.ngayhd) = 2006
order by hd.trigia desc
limit 1;

-- Cau 7: In ra danh sách 3 khách hàng (MAKH, HOTEN) có doanh số cao nhất.
SELECT kh.makh, kh.hoten from khachhang kh
order by kh.doanhso desc
limit 3;

-- Cau 8: In ra danh sách các sản phẩm (MASP, TENSP) có giá bán bằng 1 trong 3 mức giá cao nhất.
SELECT sp.masp, sp.tensp from sanpham sp
join (select sp.gia from sanpham sp order by sp.gia desc limit 3) t3 on t3.gia = sp.gia
group by sp.masp;

-- Cau 9: In ra danh sách các sản phẩm (MASP, TENSP) do “Thai Lan” sản xuất có giá bằng 1 trong 3 mức giá cao nhất.
SELECT sp.masp, sp.tensp from sanpham sp
join (select sp.gia from sanpham sp where sp.nuocsanxuat = 'Thai Lan' order by sp.gia desc limit 3) top3 on top3.gia = sp.gia
where sp.nuocsanxuat = 'Thai Lan'
group by sp.masp;

-- Cau 10: In ra danh sách các sản phẩm (MASP, TENSP) do “Trung Quoc” sản xuất có giá bằng 1 trong 3 mức giá cao nhất.
SELECT sp.masp, sp.tensp from sanpham sp
join (select sp.gia from sanpham sp where sp.nuocsanxuat = 'Trung Quoc' order by sp.gia desc limit 3) top3 on top3.gia = sp.gia
where sp.nuocsanxuat = 'Trung Quoc'
group by sp.masp;

-- Cau 11: * In ra danh sách 3 khách hàng có doanh số cao nhất (sắp xếp theo kiểu xếp hạng).
SELECT kh.hoten from khachhang kh
order by kh.doanhso desc
limit 3;

-- Cau 12: Tính tổng số sản phẩm do “Trung Quoc” sản xuất.
SELECT count(sp.masp) as 'Số sản phẩm Trung Quốc' from sanpham sp
where sp.nuocsanxuat = 'Trung Quoc';

-- Cau 13: Tính tổng số sản phẩm của từng nước sản xuất.
SELECT sp.nuocsanxuat, count(sp.masp) from sanpham sp
group by sp.nuocsanxuat;

-- Cau 14: Với từng nước sản xuất, tìm giá bán cao nhất, thấp nhất, trung bình của các sản phẩm.
SELECT sp.nuocsanxuat, max(sp.gia), min(sp.gia), avg(sp.gia) from sanpham sp
group by sp.nuocsanxuat;

-- Cau 15: Tính doanh thu bán hàng mỗi ngày.
SELECT hd.ngayhd as 'ngay', sum(hd.trigia) as 'Doanh Thu' from hoadon hd
group by hd.ngayhd;

-- Cau 16: Tính tổng số lượng của từng sản phẩm bán ra trong tháng 1/2006.
SELECT sp.tensp, sum(cthd.soluong) as 'so luong thang 1' from sanpham sp
left join cthd on cthd.masp = sp.masp
left join hoadon hd on hd.sohd = cthd.sohd
where year(hd.ngayhd) = '2006' and month(hd.ngayhd) = '1'
group by sp.masp;

-- Cau 17: Tính doanh thu bán hàng của từng tháng trong năm 2006.
SELECT year(hd.ngayhd) as 'nam', month(hd.ngayhd) as 'thang', sum(hd.trigia) as 'Doanh thu' from hoadon hd
where year(hd.ngayhd) = '2006'
group by year(hd.ngayhd), month(hd.ngayhd);

-- Cau 18: Tìm hóa đơn có mua ít nhất 4 sản phẩm khác nhau.
SELECT hd.*, count(cthd.masp) as 'SanPham khac nhau' from hoadon hd
join cthd on cthd.sohd = hd.sohd
group by cthd.sohd
having count(cthd.masp) >= 2;

-- Cau 19: Tìm hóa đơn có mua 3 sản phẩm do “Thai Lan” sản xuất (3 sản phẩm khác nhau).
SELECT hd.*, count(cthd.masp) as 'SP khacnhau TL'  from hoadon hd
join cthd on cthd.sohd = hd.sohd
join sanpham sp on sp.masp = cthd.masp
where sp.nuocsanxuat = 'Thai Lan'
group by cthd.sohd
having count(cthd.masp) = 2;

-- Cau 20: Tìm khách hàng (MAKH, HOTEN) có số lần mua hàng nhiều nhất.
SELECT kh.makh, kh.hoten, count(hd.makh) as 'so lan mua' from khachhang kh
join hoadon hd on hd.makh = kh.makh
group by hd.makh
order by count(hd.makh) desc
limit 1;

-- Cau 21: Tháng mấy trong năm 2006, doanh số bán hàng cao nhất ?
SELECT month(hd.ngayhd) as 'thang', sum(hd.trigia) as 'DS cao nhat' from hoadon hd
where year(hd.ngayhd) = '2006'
group by year(hd.ngayhd), month(hd.ngayhd)
order by sum(hd.trigia) desc
limit 1;

-- Cau 22: Tìm sản phẩm (MASP, TENSP) có tổng số lượng bán ra thấp nhất trong năm 2006.
SELECT sp.masp, sp.tensp, sum(cthd.soluong) as 'Tong so luong thap nhat' from sanpham sp
join cthd on cthd.masp = sp.masp
join hoadon hd on hd.sohd = cthd.sohd
where year(hd.ngayhd) = '2006'
group by sp.masp
order by sum(cthd.soluong)
limit 1;

-- Cau 23: *Mỗi nước sản xuất, tìm sản phẩm (MASP,TENSP) có giá bán cao nhất.
SELECT sp.nuocsanxuat, sp.masp, sp.tensp, sp.gia from sanpham sp
join (select sp.nuocsanxuat, max(sp.gia) as max_gia from sanpham sp group by sp.nuocsanxuat) as max_gia_tung_nuoc
on max_gia_tung_nuoc.nuocsanxuat = sp.nuocsanxuat and max_gia_tung_nuoc.max_gia = sp.gia;

-- Cau 24: Tìm nước sản xuất sản xuất ít nhất 3 sản phẩm có giá bán khác nhau.
SELECT sp.nuocsanxuat from sanpham sp
group by sp.nuocsanxuat
having count(sp.gia) >=3;

-- Cau 25: *Trong 10 khách hàng có doanh số cao nhất, tìm khách hàng có số lần mua hàng nhiều nhất.
SELECT kh.makh, kh.hoten, kh.doanhso ,COUNT(hd.sohd) AS solanmuahang
FROM hoadon hd
JOIN khachhang kh ON hd.makh = kh.makh
join (
  SELECT kh.makh, kh.doanhso
  FROM khachhang kh
  GROUP BY kh.makh
  ORDER BY kh.doanhso DESC
  LIMIT 10
) as doanh_so_cao on doanh_so_cao.makh = kh.makh
GROUP BY kh.makh
ORDER BY solanmuahang DESC
LIMIT 1;













