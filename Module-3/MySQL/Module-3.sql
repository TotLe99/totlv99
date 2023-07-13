create database date130623QuanLyVatTu;
use date130623QuanLyVatTu;

create table NhaCungCap(
maNCC int not null auto_increment primary key,
tenNCC varchar(60) not null,
diaChi varchar(100),
SDT varchar(20)
);

create table PhoneNhaCungCap(
sTT int not null auto_increment primary key,
maNCC int not null,
SDT varchar(20),
foreign key (maNCC) references NhaCungCap (maNCC)
);

create table DonDH(
soDH int not null auto_increment primary key,
NgayDH datetime,
maNCC int not null,
foreign key (maNCC) references NhaCungCap (maNCC)
);

create table VatTu(
maVTU int not null auto_increment primary key,
tenVTU varchar(60)
);

create table PhieuXuat(
soPX int not null auto_increment primary key,
ngayXuat datetime
);

create table Xuat(
sTT int not null auto_increment primary key,
DGXuat double not null,
SLXuat bigint not null,
soPX int not null,
maVTU int not null,
foreign key (soPX) references PhieuXuat (soPX),
foreign key (maVTU) references VatTu (maVTU)
);

create table PhieuNhap(
soPN int not null auto_increment primary key,
ngayNhap datetime
);

create table Nhap(
sTT int not null auto_increment primary key,
DGNhap double not null,
SLNhap bigint not null,
soPN int not null,
maVTU int not null,
foreign key (soPN) references PhieuNhap (soPN),
foreign key (maVTU) references VatTu (maVTU)
);

create table ChiTietDatHang(
sTT int not null auto_increment primary key,
maVTU int not null,
soDH int not null,
foreign key (maVTU) references VatTu (maVTU),
foreign key (soDH) references DonDH (soDH)
);