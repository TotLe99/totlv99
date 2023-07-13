create database slack140623DangKyXe;
use slack140623DangKyXe;

-- cau 3: liet ke xe tren 5 cho ngoi 
select * from dongxe where sochongoi >= 5;

-- cau 4: liet ke NCC cung cap TOYOTA phi 15k hoac KIA 20k
select ncc.* from nhacungcap ncc 
join dangkycungcap dkcc on ncc.MaNCC = dkcc.MaNCC
join dongxe dx on dx.DongXe = dkcc.DongXe
join mucphi mp on mp.MaMP = dkcc.MaMP
where (dx.HangXe = 'toyota' and mp.DonGia = 15000)
or (dx.HangXe = 'kia' and mp.DonGia = 20000);

-- cau 5: liet ke ncc sap xep theo ten tang va MST giam
select * from nhacungcap order by TenNCC asc;
select * from nhacungcap order by MaSoThue desc;

-- cau 6: Đếm số lần đăng ký cung cấp phương tiện tương ứng
-- cho từng nhà cung cấp với yêu cầu chỉ đếm cho những nhà cung cấp
-- thực hiện đăng ký cung cấp có ngày bắt đầu cung cấp là "20/11/2015"
select ncc.TenNCC, count(*) as SoLanDangKy from nhacungcap ncc
join dangkycungcap dkcc on ncc.MaNCC = dkcc.MaNCC
where dkcc.NgayBatDauCungCap = '2020-03-13' group by ncc.TenNCC;

select ncc.TenNCC, count(*) as SoLanDangKy from nhacungcap ncc
join dangkycungcap dkcc on ncc.MaNCC = dkcc.MaNCC
where dkcc.NgayBatDauCungCap = '2021-04-04' group by ncc.TenNCC;

-- cau 7: liet ke all hang xe
select HangXe from dongxe;

-- cau 8: Liệt kê MaDKCC, MaNhaCC, TenNhaCC, DiaChi, MaSoThue, TenLoaiDV, DonGia, HangXe, NgayBatDauCC, NgayKetThucCC
-- của tất cả các lần đăng ký cung cấp phương tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký
-- cung cấp phương tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra
select dkcc.MaDKCC, ncc.MaNCC, ncc.TenNCC, ncc.DiaChi, ncc.MaSoThue, ldv.TenLDV, mp.DonGia,
dkcc.NgayBatDauCungCap, dkcc.NgayKetThucCungCap from nhacungcap ncc
left join dangkycungcap dkcc on ncc.MaNCC = dkcc.MaNCC
left join mucphi mp on mp.MaMP = dkcc.MaMP
left join dongxe dx on dx.DongXe = dkcc.DongXe
left join loaidichvu ldv on ldv.MaLDV = dkcc.MaLDV
where dkcc.MaDKCC is not null or dkcc.MaDKCC is null;

-- cau 9: Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện thuộc dòng xe "Fog"
-- hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe "Kia"
select ncc.*, dx.HangXe from nhacungcap ncc
left join dangkycungcap dkcc on ncc.MaNCC = dkcc.MaNCC
left join dongxe dx on dx.DongXe = dkcc.DongXe
where dx.HangXe = 'Fog' or dx.HangXe = 'Kia';

-- cau 10: Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp phương tiện lần nào cả.
select ncc.*, dkcc.MaDKCC from nhacungcap ncc
left join dangkycungcap dkcc on ncc.MaNCC = dkcc.MaNCC
where dkcc.MaDKCC is null;