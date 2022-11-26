create database CSDL_QLBDS_N2
use CSDL_QLBDS_N2

create table NHANVIEN(
maNV varchar(10) primary key,
hinh varchar(50),
maQR varchar(50),
maSGD int,
hoTen nvarchar (30),
ngaySinh date,
Sdt nvarchar(10),
soNoiBo nvarchar(10),
chucDanh nvarchar(30),
matKhau nvarchar (50),
maQuanLy nvarchar (30),
gioiTinh bit,
lockCheckBox bit,
)
alter table NHANVIEN
add constraint FK_NHANVIEN_SANGIAODICH foreign key (maSGD) references SANGIAODICH(maSGD)



create table LICHTHANHTOAN(
dot int primary key,
ngayTT date ,
tyLeTT float ,
kieuTT nvarchar(50),
tamUng float,
thueVat float, 
daThu float,
conLai float,
dienGiai nvarchar(255),
maSPDA varchar(10), 
maKH varchar (10)

)
alter table LICHTHANHTOAN
add constraint FK_LICHTHANHTOAN_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)


create table CHINHSACHBANHANG(
soHieu varchar(10) primary key,
ngayBatDau date,
ngayKetThuc date,
loaiChinhSach nvarchar(255),
soLuong float,
dieuKien nvarchar(255),
chietKhau float,
tienThuongPhat float,
dienGiai nvarchar (255),
maSPDA varchar(10)

)



alter table CHINHSACHBANHANG
add constraint FK_CHINHSACHBANHANG_SANPHAMDUAN foreign key (maSPDA) references SANPHAMDUAN(maSPDA)

create table TAILIEUDUAN(
kyhieu int identity(1,1),
tenTaiLieu nvarchar (255),
dienGiai nvarchar (255),
nhanVien nvarchar (55),
ngayCapNhat date,
maSPDA varchar (10)

)


alter table TAILIEUDUAN
add constraint FK_TAILIEUDUAN_SANPHAMDUAN foreign key (maSPDA) references SANPHAMDUAN(maSPDA)

create table PHIEU(
maPhieu varchar(10) primary key,
ngayCoc date ,
maSPDA varchar(10),
donGia money ,
dienTich float ,
soLoCoc int ,
thanhTien money,
tienCoc money ,
maNV varchar(10),
maKH varchar (10),
loaiPhieu varchar(50)

)
alter table PHIEU
add constraint FK_PHIEU_SANPHAMDUAN foreign key (maSPDA) references SANPHAMDUAN(maSPDA),
constraint FK_PHIEU_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)

create table HOPDONG(
soHopDong varchar (255) primary key not null,
STT int,
ngayKy date,
dienTich float,
donGia float,
thanhTien money,
soPhieu varchar(10),
maSPDA varchar(10),
trangThai nvarchar(50),
maKH varchar (10)

)

alter table HOPDONG
add constraint FK_HOPDONG_KHACHHANG foreign key (maKH) references KHACHHANG(maKH),
constraint FK_HOPDONG_SANPHAMDUAN foreign key (maSPDA) references SANPHAMDUAN(maSPDA)


create table CHUYENNHUONG(
maCN int primary key not null,
soHopDong varchar (255),
khachHang nvarchar (255),
maSanPham varchar (10),
giaBan money ,
chietKhau float ,
cong money ,
phiMoiGioi money ,
thoiHan date ,
ngayNhap date 

)

alter table CHUYENNHUONG
add constraint FK_CHUYENNHUONG_HOPDONG foreign key (soHopDong) references HOPDONG(soHopDong)


create table MAIL(
soMail int identity(1,1),
maNV varchar(10) ,
emailNguoiNhan nvarchar(255) ,
noiDung nvarchar (255),
Email nvarchar (255)
)
alter table MAIL
add constraint FK_MAIL_NHANVIEN foreign key (maNV) references NHANVIEN(maNV)

create table SMS(
Sdt nvarchar(10) primary key,
maNV varchar(10) ,
sdtNguoiNhan varchar (30),
ngayGui date,
noiDung nvarchar(255)

)

alter table SMS
add constraint FK_SMS_NHANVIEN foreign key (maNV) references NHANVIEN(maNV)


create table LICHSULAMVIEC(
maLSLV varchar (10) primary key ,
STT int,
tieuDe varchar (255),
maNV varchar(10),
ngayBatDau date ,
ngayKetThuc date ,
maKH varchar (10)

)
alter table LICHSULAMVIEC
add constraint FK_LICHSULAMVIEC_NHANVIEN foreign key (maNV) references NHANVIEN(maNV),
constraint FK_LICHSULAMVIEC_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)


create table KHACHHANG(
maKH varchar (10) primary key ,
STT int ,
danhXung nvarchar (255),
hoTenDem nvarchar (255),
ten nvarchar (50),
ngaySinh date ,
Sdt varchar (15),
diaChiLienLac  varchar (255),
diaChiThuongTru varchar (255),
Email varchar (255),
maThue varchar (15),
loai nvarchar (50),
CCCD int ,
gioiTinh bit
)

create table LICHSUGIAODICH(
MaLSGD varchar (10) primary key,
ngayGD date,
maGD varchar(10),
loaiGD nvarchar (255),
maSPDA varchar (10),
dienTich float ,
thanhTien money ,
dienGiai nvarchar (255),
nhanVien nvarchar (55),
sanGiaoDich nvarchar (255),
maKH varchar (10)
)

alter table LICHSUGIAODICH
add constraint FK_LICHSUGIAODICH_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)


create table NGUOIDAIDIEN(
maDD varchar(10) primary key,
hoTen nvarchar (255),
SdtCoDinh varchar (10),
SdtDiDong varchar (10),
Email varchar (255),
diaChiLienLac nvarchar (255),
diaChiThuongTru nvarchar (255),
gioiTinh bit,
ngaySinh date ,
maKH varchar (10)

)
alter table NGUOIDAIDIEN
add constraint FK_NGUOIDAIDIEN_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)

create table NGUOIGIOITHIEU(
maGT varchar(10) primary key,			
hoTen nvarchar (255),
SdtCoDinh varchar (10),
SdtDiDong varchar (10),
Email varchar (255),
diaChiLienLac nvarchar (255),
diaChiThuongTru nvarchar (255),
gioiTinh bit ,
ngaySinh date ,
maKH varchar (10),
hoahong float
)

alter table NGUOIGIOITHIEU
add constraint FK_NGUOIGIOITHIEU_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)

create table SANGIAODICH(
maSGD int primary key,
sanGiaoDich nvarchar (255) ,
Sdt varchar (10),
diaChi nvarchar (255),
nguoiLienHe nvarchar (30),
chucVu nvarchar (50),
SdtNLH varchar (50),
nhanVienQuanLy nvarchar (255),
nhanVienTao nvarchar (255),
ngayTao date
)

create table SANPHAMDUAN(
maSPDA varchar(10) primary key,
maDA varchar(10),
tenDA nvarchar(255),
diaChi nvarchar(255),
dienTich float,
soGiayPhep int,
ngayCap date,
noiCap nvarchar(255),
loaiDA nvarchar(255),
maNVPhuTrach varchar(10),
ngayDang date,
maSGD int
)

create table QUANLYDUAN(
	maDA varchar(10) primary key not null,
	ngayDang date,
	tenDA nvarchar(50),
	diaChi nvarchar(255),
	dienTich float,
	soGiayPhep int,
	ngayCap date,
	noiCap nvarchar(50),
	loaiDA nvarchar(50),
	maNVPhuTrach varchar(10)		
)

create table CONGNO(
soCongNo int identity(1,1),
maKH varchar(10),
hoTen nvarchar(255),
maGD varchar(10),
tenDA nvarchar(50),
tamUng float,
thueVat float,
phaiThu float,
daThu float,
conLai float,
laiNopCham int,
chietKhau float,
cong float
)

 alter table SANPHAMDUAN
add constraint FK_SANPHAMDUAN_QUANLYDUAN foreign key (maDA) references QUANLYDUAN(maDA),
	constraint FK_SANPHAMDUAN_SANGIAODICH foreign key (maSGD) references SANGIAODICH(maSGD)

alter table CONGNO
add constraint FK_CONGNO_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)

 alter table LICHTHANHTOAN
add constraint FK_LICHTHANHTOAN_SANPHAMDUAN foreign key (maSPDA) references SANPHAMDUAN(maSPDA)



alter table LICHSUGIAODICH
add constraint FK_LICHSUGIAODICH_SANPHAMDUAN foreign key (maSPDA) references SANPHAMDUAN(maSPDA)

insert into NHANVIEN
values ('NV01','KhanhTan.png','TongKhanhTan.png','121',N'Tống Khánh Tân','1997/10/29','0341864927','0824195381',N'Quản Lý','QL01',null,0,1),
		('NV02','VanDet.png','HoVanDet.png','122',N'Hồ Văn Đẹt','1990/02/02','0989895612','0802834343',N'Quản Lý','NV02',null,0,1),
		('NV03','TruongGiang.png','NguyenVuTruongGiang.png','123',N'Nguyễn Vũ Trường Giang','1990/11/12','0955286492','0829235381',N'Nhân Viên','NV03','QL01',0,1),
		('NV04','ThanhVy.png','TranThanhVy.png','124',N'Trần Thanh Vy','1997/11/24','0399964921','0820755381',N'Nhân Viên','NV04','QL02',1,1),
		('NV05','ThuThuy.png','NguyenThiThuThuy.png','125',N'Nguyễn Thị Thu Thủy','1997/11/02','0341877729','0353695381',N'Nhân Viên','NV05','QL01',1,0),
		('NV06','NgocHa.png','NguyenThiNgocHa.png','126',N'Nguyễn Thị Ngọc Hà','1998/01/13','0341800027','0824194536',N'Quản Lý','QL03',null,1,1),
		('NV07','ThuyTien.png','NguyenThucThuyTien.png','127',N'Nguyễn Thúc Thùy Tiên','1999/10/30','0341845612','0802895381',N'Nhân Viên','NV07','QL02',1,0),
		('NV08','ThanhPhong.png','VoThanhPhong.png','128',N'Võ Thanh Phong','1992/07/01','0195302519','0251820372',N'Nhân Viên','NV08','QL01',0,1),
		('NV09','DaiPhu.png','NguyenLeDaiPhu.png','129',N'Nguyễn Lê Đại Phú','1999/03/12','0978786798','0856271592',N'Nhân Viên','NV09','QL03',0,1),
		('NV10','MinhNhut.png','HuynhMinhNhut.png','130',N'Huỳnh Minh Nhựt','1998/07/07','0915628712','0925271892',N'Nhân Viên','NV10','QL03',0,0)

insert into LICHTHANHTOAN
values ('1','2022/09/10','10',N'Tiền Mặt','500000000','1','500000000','1000000000',N'Đợt 1','SPDA201','KH001'),
('2','2022/09/20','20',N'Chuyển Khoản','450000000','2','450000000','550000000',N'Đợt 2','SPDA201','KH001'),
('3','2022/10/01','30',N'Chuyển Khoản','550000000','3','550000000','0',N'Đợt cuối','SPDA201','KH001'),

('1','2022/09/12','10',N'Tiền Mặt','700000000','1','700000000','500000000',N'Đợt 1','SPDA202','KH002'),
('2','2022/09/22','20',N'Chuyển Khoản','500000000','1','500000000','0',N'Đợt cuối','SPDA202','KH002'),

('1','2022/11/11','10',N'Tiền Mặt','800000000','1','800000000','0',N'Đợt 1','SPDA203','KH003'),

('1','2022/07/28','10',N'Tiền Mặt','500000000','1','500000000','0',N'Đợt 1','SPDA204','KH004'),

('1','2022/10/10','10',N'Tiền Mặt','1000000000','1','100000000','1000000000',N'Đợt 1','SPDA205','KH005'),
('2','2022/11/10','20',N'Tiền Mặt','1000000000','3','1000000000','0',N'Đợt cuối','SPDA205','KH005'),

('1','2022/08/08','10',N'Tiền Mặt','500000000','1','500000000','500000000',N'Đợt 1','SPDA206','KH006'),
('2','2022/09/08','20',N'Chuyển Khoản','200000000','2','200000000','300000000',N'Đợt 2','SPDA206','KH006'),
('3','2022/10/08','30',N'Chuyển Khoản','300000000','3','300000000','0',N'Đợt cuối','SPDA206','KH006'),

('1','2022/10/10','10',N'Tiền Mặt','500000000','1','500000000','1500000000',N'Đợt 1','SPDA207','KH007'),
('2','2022/10/20','20',N'Tiền Mặt','500000000','2','500000000','1000000000',N'Đợt 2','SPDA207','KH007'),
('3','2022/10/30','30',N'Tiền Mặt','500000000','3','500000000','500000000',N'Đợt 3','SPDA207','KH007'),
('4','2022/11/10','40',N'Tiền Mặt','500000000','4','500000000','0',N'Đợt cuối','SPDA207','KH007'),

('1','2022/09/03','10',N'Tiền Mặt','2000000000','1','200000000','1000000000',N'Đợt 1','SPDA208','KH008'),
('2','2022/09/23','20',N'Tiền Mặt','1000000000','2','1000000000','0',N'Đợt cuối','SPDA208','KH008'),

('1','2022/12/11','10',N'Tiền Mặt','100000000','1','100000000','0',N'Đợt 1','SPDA209','KH009'),

('1','2022/07/07','10',N'Tiền Mặt','2000000000','1','2000000000','1000000000',N'Đợt 1','SPDA210','KH010'),
('2','2022/08/08','20',N'Tiền Mặt','700000000','2','700000000','300000000',N'Đợt 2','SPDA210','KH010'),
('3','2022/09/09','30',N'Chuyển Khoản','300000000','3','300000000','0',N'Đợt cuối','SPDA210','KH010')

insert into CHINHSACHBANHANG 
values('CSBH-0001','2022/09/10','2022/10/01',N'Thanh toán trễ hạn',null,'30 ','3','20000000',N'Phạt tăng lãi suất và tiền phạt theo nghị định kèm theo','SPDA201'),
('CSBH-0002','2022/09/12','2022/09/22',N'Thanh toán đúng hạng',null,'10 ','1','40000000',N'Khách hàng nào thanh toán đúng theo chính sách sẽ được ưu đãi','SPDA202'),
('CSBH-0003','2022/11/11',null,N'Thanh toán ngay',null,null,'0','5000000',N'Khách hàng nào thanh toán đúng theo chính sách sẽ được ưu đãi','SPDA203'),
('CSBH-0004','2022/07/28',null,N'Thanh toán ngay',null,0,'0','30000000',N'Khách hàng nào thanh toán đúng theo chính sách sẽ được ưu đãi','SPDA204'),
('CSBH-0005','2022/10/10','2022/11/10',N'Thanh toán trễ hạn',null,'30 ','3','20000000',N'Phạt tăng lãi suất và tiền phạt theo nghị định kèm theo','SPDA205'),
('CSBH-0006','2022/08/08','2022/10/08',N'Thanh toán trễ hạn',null,'90 ','9','60000000',N'Phạt tăng lãi suất và tiền phạt theo nghị định kèm theo','SPDA206'),
('CSBH-0007','2022/10/10','2022/11/10',N'Thanh toán trễ hạn',null,'30 ','3','20000000',N'Phạt tăng lãi suất và tiền phạt theo nghị định kèm theo','SPDA207'),
('CSBH-0008','2022/09/03','2022/09/23',N'Thanh toán đúng hạn',null,'20 ','2','10000000',N'Khách hàng nào thanh toán đúng theo chính sách sẽ được ưu đãi','SPDA208'),
('CSBH-0009','2022/12/11',null,N'Thanh toán ngay',null,null,'0','60000000',N'Khách hàng nào thanh toán đúng theo chính sách sẽ được ưu đãi','SPDA209'),
('CSBH-0010','2022/07/07','2022/09/09',N'Thanh toán trễ hạn',null,'90 ','9','90000000',N'Phạt tăng lãi suất và tiền phạt theo nghị định kèm theo','SPDA210')

insert into TAILIEUDUAN
values (N'Mặt bằng quận 1',N'Mua mặt bằng',N'Trần Thanh Vy','2022/10/10','SPDA201'),
(N'Chung cư Phát Đạt','Mua đất chung cư',N'Trần Thanh Vy','2022/10/01','SPDA202'),
(N'Mặt bằng quận 4',N'Mua mặt bằng',N'Võ Thanh Phong','2022/11/12','SPDA203'),
(N'Bờ kè quận 2',N'Mua mặt bằng',N'Nguyễn Lê Đại Phú','2022/08/01','SPDA204'),
(N'Chung cư Diêm Vương ',N'Mua căn chung cư',N'Nguyễn Thúc Thùy Tiên','2022/11/14','SPDA205'),
(N'Mặt bằng quận 1',N'Mua đất mặt tiền',N'Nguyễn Thị Thu Thủy','2022/10/10','SPDA206'),
(N'Mặt bằng quận 3',N'Mua mặt bằng',N'Nguyễn Vũ Trường Giang','2022/11/10','SPDA207'),
(N'Mặt bằng quận Bình Thạnh',N'Đất mặt tiền',N'Trần Thanh Vy','2022/10/01','SPDA208'),
(N'Mặt bằng quận Hóc Môn',N'Mua mặt bằng',N'Nguyễn Thúc Thùy Tiên','2022/12/15','SPDA209'),
(N'Mặt bằng quận 7',N'Đất mặt tiền',N'Huỳnh Minh Nhựt','2022/07/10','SPDA210')

insert into PHIEU 
values ('PH001','2022/09/10','SPDA201','2000000000','200','3','2000000000','1000000000','NV04','KH001',N'Phiếu giữ chỗ'),
('PH002','2022/09/12','SPDA202','1300000000','150','2','1300000000','700000000','NV04','KH002',N'Phiếu đặt cọc'),
('PH003','2022/11/11','SPDA203','800000000','100','1','800000000','800000000','NV08','KH003',N'Phiếu đặt cọc'),
('PH004','2022/07/28','SPDA204','500000000','70','1','500000000','500000000','NV09','KH004',N'Phiếu đặt coc'),
('PH005','2022/10/10','SPDA205','2000000000','120','2','2000000000','1000000000','NV07','KH005',N'Phiếu giữ chỗ '),
('PH006','2022/08/08','SPDA206','1000000000','100','3','1000000000','500000000','NV05','KH006',N'Phiếu giữ chỗ'),
('PH007','2022/10/10','SPDA207','2000000000','200','4','2000000000','500000000','NV03','KH007',N'Phiếu giữ chỗ'),
('PH008','2022/09/03','SPDA208','3000000000','500','3','3000000000','2000000000','NV04','KH008',N'Phiếu đặt cọc'),
('PH009','2022/12/11','SPDA209','1000000000','200','2','1000000000','1000000000','NV04','KH009',N'Phiếu đặt cọc'),
('PH010','2022/07/07','SPDA210','3000000000','250','1','3000000000','2000000000','NV10','KH010',N'Phiếu giữ chỗ')


insert into HOPDONG 
values ('HD-1','1','2022/09/10','200','2000000000','2000000000','PH001','SPDA201','Đã cọc','KH001'),
('HD-2','2','2022/09/12','150','1300000000','1300000000','PH002','SPDA202','Đã cọc','KH002'),
('HD-3','3','2022/11/11','100','800000000','800000000','PH003','SPDA203','Đã cọc','KH003'),
('HD-4','4','2022/07/28','70','500000000','500000000','PH004','SPDA204','Đã cọc','KH004'),
('HD-5','5','2022/10/10','120','2000000000','2000000000','PH005','SPDA205','Đã cọc','KH005'),
('HD-6','6','2022/08/08','100','1000000000','1000000000','PH006','SPDA206','Đã cọc','KH006'),
('HD-7','7','2022/10/10','200','2000000000','2000000000','PH007','SPDA207','Đã cọc','KH007'),
('HD-8','8','2022/09/03','500','3000000000','3000000000','PH008','SPDA208','Đã cọc','KH008'),
('HD-9','9','2022/12/11','200','1000000000','1000000000','PH009','SPDA209','Đã cọc','KH009'),
('HD-10','10','2022/07/07','250','3000000000','3000000000','PH010','SPDA210','Đã cọc','KH010')

insert into CHUYENNHUONG
values ('111','HD-1',N'Lê Công Vinh','SP201','2000000000','3','200000000','100000000','2022/10/01','2022/10/02'),
('112','HD-2',N'Nguyễn Văn Toàn','SP202','1300000000','1','10000000','10000000','2022/09/22','2022/09/23'),
('113','HD-3',N'Trần Thị Thanh Thảo','SP203','800000000','1','10000000','10000000','2022/11/11','2022/11/12'),
('114','HD-4',N'Mạc Văn Khoa','SP204','500000000','1','10000000','10000000','2022/07/28','2022/07/30'),
('115','HD-5',N'Trần Thanh Tâm','SP205','2000000000','3','20000000','100000000','2022/11/10','2022/11/11'),
('116','HD-6',N'Bành Thị Bé Tư','SP206','1000000000','3','20000000','100000000','2022/10/08','2022/10/10'),
('117','HD-7',N'Lê Thanh Chú Bảy','SP207','2000000000','3','20000000','100000000','2022/11/10','2022/11/11'),
('118','HD-8',N'Nguyễn Thị Ngọc Bội','SP208','3000000000','1','20000000','100000000','2022/09/23','2022/09/24'),
('119','HD-9',N'Lê Quang ĐótKi','SP209','1000000000','1','20000000','100000000','2022/12/11','2022/12/12'),
('120','HD-10',N'Lưu Vĩ Tâm Như','SP210','3000000000','3','20000000','100000000','2022/09/09','2022/09/10')

insert into MAIL 
values ('NV01','khanhnhut1212@gmail.com','bla bla','khanhtan203@gmailcom'),
('NV02','vanvan231@gmail.com','bla bla','vandetho0202@gmailcom'),
('NV03','truongchinh718@gmail.com','bla bla','truonggiang1112@gmailcom'),
('NV04','tranthanhbach@gmail.com','bla bla','thanhvyngu2411@gmailcom'),
('NV05','thuthao0124@gmail.com','bla bla','thuthuy0211@gmailcom'),
('NV06','kimngan1101@gmail.com','bla bla','ngocha1301@gmailcom'),
('NV07','thuynu1910@gmail.com','bla bla','thuytien3010@gmailcom'),
('NV08','thanhthuy1111@gmail.com','bla bla','thanhphong0107@gmailcom'),
('NV09','daibac9090@gmail.com','bla bla','daiphu1203@gmailcom'),
('NV10','minhtam0011@gmail.com','bla bla','minhnhut0707@gmailcom')

insert into SMS 
values ('0341864927','NV01','0824195381','2022/10/10','bla bla'),
('0989895612','NV02','0802834343','2022/10/20','bla bla'),
('0955286492','NV03','0829235381','2022/10/30','bla bla'),
('0399964921','NV04','0820755381','2022/11/10','bla bla'),
('0341877729','NV05','0353695381','2022/11/11','bla bla'),
('0341800027','NV06','0824194536','2022/11/20','bla bla'),
('0341845612','NV07','0802895381','2022/11/30','bla bla'),
('0195302519','NV08','02518203727','2022/12/10','bla bla'),
('0978786798','NV09','0856271592','2022/11/16','bla bla'),
('0915628712','NV10','0925271892','2022/10/19','bla bla')

insert into LICHSULAMVIEC
values ('LSLV01','1','Hop Dong SPDA 1','NV04','2022/09/10','2022/10/01','KH001'),
('LSLV02','2','Hop Dong SPDA 2','NV04','2022/09/12','2022/09/22','KH002'),
('LSLV03','3','Hop Dong SPDA 3','NV08','2022/11/11','2022/11/11','KH003'),
('LSLV04','4','Hop Dong SPDA 4','NV09','2022/07/28','2022/07/28','KH004'),
('LSLV05','5','Hop Dong SPDA 5','NV07','2022/10/10','2022/11/10','KH005'),
('LSLV06','6','Hop Dong SPDA 6','NV05','2022/08/08','2022/10/08','KH006'),
('LSLV07','7','Hop Dong SPDA 7','NV03','2022/10/10','2022/11/10','KH007'),
('LSLV08','8','Hop Dong SPDA 8','NV04','2022/09/03','2022/09/23','KH008'),
('LSLV09','9','Hop Dong SPDA 9','NV04','2022/12/11','2022/12/11','KH009'),
('LSLV10','10','Hop Dong SPDA 10','NV10','2022/07/07','2022/09/09','KH010')

insert into KHACHHANG
values ('KH001','1',N'Mr Tèo',N'Lê Công',N'Vinh','1989/12/12','0708090102',N'106/2/Hai Bà Trưng/Q.1',N'106/2/Hai Bà Trưng/Q.1','congvinh1212@gmail.com','TH01',N'Cá Nhân','0807080706',0),
('KH002','2',N'Mr Tủn',N'Nguyễn Văn ',N'Toàn','1990/11/11','0381930214',N'107/3/Hai Bà Trưng/Q.1',N'107/3/Hai Bà Trưng/Q.1','vantoan1111@gmail.com','TH02',N'Cá Nhân','0807080705',0),
('KH003','3',N'Mr Tí',N'Trần Thị Thanh',N'Thảo','1988/10/10','0721314265',N'16/Trần Quốc Toản/Q.1',N'16/Trần Quốc Toản/Q.1','thanhthao1010@gmail.com','TH03',N'Cá Nhân','0807080704',1),
('KH004','4',N'Mr Tẹo',N'Mạc Văn',N'Khoa','1989/09/09','0888889999',N'310/Dương Quảng Hàm/Q.Gò Vấp',N'90/90/Phan Bội Châu/Q.8','vankhoa0909@gmail.com','TH04',N'Cá Nhân','0807080703',0),
('KH005','5',N'Mr Tẹt',N'Trần Thanh',N'Tâm','1987/08/08','0708000212',N'120/45/Phan Chu Trinh/Q.2',N'123/Nguyễn Huệ/Q.2','thanhtam0808@gmail.com','TH05',N'Cá Nhân','0807080702',1),
('KH006','6',N'Mr Téo',N'Bành Thị Bé',N'Tư','1983/07/07','0799990102',N'111/1/Chu Hoa Thám/Q.6',N'111/1/Chu Hoa Thám/Q.6','betu0707@gmail.com','TH06',N'Cá Nhân','0807080701',1),
('KH007','7',N'Mr Tẽo',N'Lê Thanh Chú',N'Bảy','1986/06/06','0708091112',N'222/Phan Bội Châu/Q.7',N'222/Phan Bội Châu/Q.7','chubay0606@gmail.com','TH07',N'Cá Nhân','0807080700',0),
('KH008','8',N'Mr Toan',N'Nguyễn Thị Ngọc',N'Bội','1990/05/05','0707878102',N'123/Nguyễn Huệ/Q.2',N'120/45/Phan Chu Trinh/Q.2','ngocboi0505@gmail.com','TH08',N'Cá Nhân','0807080709',1),
('KH009','9',N'Mr Tặc',N'Lê Quang',N'ĐótKi','1997/04/04','0708980802',N'90/90/Phan Bội Châu/Q.8',N'310/Dương Quảng Hàm/Q.Gò Vấp','dotki0404@gmail.com','TH09',N'Cá Nhân','0807080710',0),
('KH010','10',N'Mr Tem',N'Lưu Vĩ Tâm',N'Như','1999/03/03','0708067543',N'1101/Bùi Viện/Q.1',N'1101/Bùi Viện/Q.1','tamnhu0303@gmail.com','TH10',N'Cá Nhân','0807080708',1)

insert into LICHSUGIAODICH
values  ('LSGD01','2022/09/10','GD01',N'Tiền Mặt','SPDA201','200','2000000000','bla bla',N'Trần Thanh Vy',N'Sàn Giao Dịch A','KH001'),
		('LSGD02','2022/09/12','GD02',N'Tiền Mặt','SPDA202','150','1300000000','bla bla',N'Trần Thanh Vy',N'Sàn Giao Dịch B','KH002'),
		('LSGD03','2022/11/11','GD03',N'Tiền Mặt','SPDA203','100','800000000','bla bla',N'Võ Thanh Phong',N'Sàn Giao Dịch C','KH003'),
		('LSGD04','2022/07/28','GD04',N'Tiền Mặt','SPDA204','70','500000000','bla bla',N'Nguyễn Lê Đại Phú',N'Sàn Giao Dịch D','KH004'),
		('LSGD05','2022/10/10','GD05',N'Tiền Mặt','SPDA205','120','2000000000','bla bla',N'Nguyễn Thúc Thùy Tiên',N'Sàn Giao Dịch E','KH005'),
		('LSGD06','2022/08/08','GD06',N'Tiền Mặt','SPDA206','100','1000000000','bla bla',N'Nguyễn Thị Thu Thủy',N'Sàn Giao Dịch F','KH006'),
		('LSGD07','2022/10/10','GD07',N'Tiền Mặt','SPDA207','200','2000000000','bla bla',N'Nguyễn Vũ Trường Giang',N'Sàn Giao Dịch K','KH007'),
		('LSGD08','2022/09/03','GD08',N'Tiền Mặt','SPDA208','500','3000000000','bla bla',N'Trần Thanh Vy',N'Sàn Giao Dịch H','KH008'),
		('LSGD09','2022/12/11','GD09',N'Tiền Mặt','SPDA209','200','1000000000','bla bla',N'Nguyễn Thúc Thùy Tiên',N'Sàn Giao Dịch G','KH009'),
		('LSGD10','2022/07/07','GD10',N'Tiền Mặt','SPDA210','250','3000000000','bla bla',N'Huỳnh Minh Nhựt',N'Sàn Giao Dịch J','KH010')

insert into NGUOIDAIDIEN
values ('DD01',N'Lê Công Vinh','0708090102','0708090102','congvinh1212@gmail.com',N'106/2/Hai Bà Trưng/Q.1',N'106/2/Hai Bà Trưng/Q.1',0,'1989/12/12','KH001'),
('DD02',N'Nguyễn Văn Toàn','0381930214','0381930214','vantoan1111@gmail.com',N'107/3/Hai Bà Trưng/Q.1',N'107/3/Hai Bà Trưng/Q.1',0,'1990/11/11','KH002'),
('DD03',N'Trần Thị Thanh Thảo','0721314265','0721314265','thanhthao1010@gmail.com',N'16/Trần Quốc Toản/Q.1',N'16/Trần Quốc Toản/Q.1',1,'1988/10/10','KH003'),
('DD04',N'Mạc Văn Khoa','0888889999','0888889999','vankhoa0909@gmail.com',N'310/Dương Quảng Hàm/Q.Gò Vấp',N'90/90/Phan Bội Châu/Q.8',0,'1989/09/09','KH004'),
('DD05',N'Trần Thanh Tâm','0708000212','0708000212','thanhtam0808@gmail.com',N'120/45/Phan Chu Trinh/Q.2',N'123/Nguyễn Huệ/Q.2',1,'1987/08/08','KH005'),
('DD06',N'Bành Thị Bé Tư','0799990102','0799990102','betu0707@gmail.com',N'111/1/Chu Hoa Thám/Q.6',N'111/1/Chu Hoa Thám/Q.6',1,'1983/07/07','KH006'),
('DD07',N'Lê Thanh Chú Bảy','0708091112','0708091112','chubay0606@gmail.com',N'222/Phan Bội Châu/Q.7',N'222/Phan Bội Châu/Q.7',0,'1986/06/06','KH007'),
('DD08',N'Nguyễn Thị Ngọc Bội','0707878102','0707878102','ngocboi0505@gmail.com',N'123/Nguyễn Huệ/Q.2',N'120/45/Phan Chu Trinh/Q.2',1,'1990/05/05','KH008'),
('DD09',N'Lê Quang ĐótKi','0708980802','0708980802','dotki0404@gmail.com',N'90/90/Phan Bội Châu/Q.8',N'310/Dương Quảng Hàm/Q.Gò Vấp',0,'1997/04/04','KH009'),
('DD10',N'Lưu Vĩ Tâm Như','0708067543','0708067543','tamnhu0303@gmail.com',N'1101/Bùi Viện/Q.1',N'1101/Bùi Viện/Q.1',1,'1999/03/03','KH010')

insert into NGUOIGIOITHIEU
values  ('GT01',N'Nguyễn Công Trứ','0708090102','0708090102','congtru1123@gmail.com',N'102/9/Hoàng Hoa Thám/Q.3',N'16/1/Hoàng Hoa Thám/Q.3',0,'1999/06/07','KH001','20000000'),
('GT02',N'Nguyễn Bỉnh Khiêm','0381930214','0381930214','binhhiem555@gmail.com',N'17/23/Hai Bà Trưng/Q.1',N'17/23/Hai Bà Trưng/Q.1',0,'1991/11/17','KH002','15000000'),
('GT03',N'Lê Quang Đại','0721314265','0721314265','quangdai010@gmail.com',N'160/Quang Trung/Q.12',N'160/Quang Trung/Q.12',0,'1989/05/12','KH003','30000000'),
('GT04',N'Trần Hưng Thịnh','0888889999','0888889999','hungthinh09@gmail.com',N'260/Dương Quảng Hàm/Q.Gò Vấp',N'90/70/Phan Bội Châu/Q.8',0,'1995/01/01','KH004','10000000'),
('GT05',N'Huỳnh Văn Tư','0708000212','0708000212','vantu808@gmail.com',N'120/45/12/Phan Bội Châu/Q.2',N'123/2/Nguyễn Huệ/Q.2',0,'1997/12/19','KH005','20000000'),
('GT06',N'Loan Thị Ngọc Gìau','0799990102','0799990102','ngocgiau0707@gmail.com',N'111/1/Ngô Quyền/Q.10',N'111/1/Ngoo Quyền/Q.10',1,'1992/11/07','KH006','15000000'),
('GT07',N'Lê Huỳnh Công Toàn','0708091112','0708091112','congtoan6606@gmail.com',N'222/1/Lý Nhã Kỳ/Q.9',N'222/1/Lý Nhã Kỳ/Q.9',0,'1994/06/19','KH007','10000000'),
('GT08',N'Lê Vĩ Kim Ngưu','0707878102','0707878102','kimnguu885@gmail.com',N'134/Quang Trung/Q.12',N'120/45/Phạm Văn Chiêu/Q.12',1,'1990/03/25','KH008','12000000'),
('GT09',N'Lê Ô Nan MétSi','0708980802','0708980802','leonanmessi00@gmail.com',N'90/90/Lê Công Uẩn/Q.8',N'310/12/4/Dương Quảng Hàm/Q.Gò Vấp',0,'1998/08/04','KH009','17000000'),
('GT10',N'Trần Huỳnh Ái Vy','0708067543','0708067543','aivy903@gmail.com',N'1101/Lê Lợi/Q.10',N'1101/Lê Lợi/Q.10',1,'2000/03/09','KH010','30000000')

insert into SANGIAODICH
values ('121',N'Sàn Giao Dịch A','0345678910',N'222/Hai Bà Trưng/Q1',N'Lê Công Vinh',N'Trưởng Phòng','0708090102',N'Trần Thanh Vy',N'Tống Khánh Tân','2022/01/01'),
('122',N'Sàn Giao Dịch B','0333333333',N'333/Bùi Viện/Q1',N'Nguyễn Văn Toàn',N'Trưởng Phòng','0381930214',N'Trần Thanh Vy',N'Hồ Văn Đẹt','2022/02/02'),
('123',N'Sàn Giao Dịch C','0987654321',N'444/Nguyễn Huệ/Q2',N'Trần Thị Thanh Thảo',N'Trưởng Phòng','0721314265',N'Võ Thanh Phong',N'Tống Khánh Tân','2022/03/03'),
('124',N'Sàn Giao Dịch D','0345678910',N'222/Hai Bà Trưng/Q1',N'Mạc Văn Khoa',N'Trưởng Phòng','0888889999',N'Nguyễn Lê Đại Phú',N'Nguyễn Thị Ngọc Hà','2022/01/01'),
('125',N'Sàn Giao Dịch E','0333333333',N'333/Bùi Viện/Q1',N'Trần Thanh Tâm',N'Trưởng Phòng','0708000212',N'Nguyễn Thúc Thùy Tiên',N'Hồ Văn Đẹt','2022/02/02'),
('126',N'Sàn Giao Dịch F','0987654321',N'444/Nguyễn Huệ/Q2',N'Bành Thị Bé Tư',N'Trưởng Phòng','0799990102',N'Nguyễn Thị Thu Thủy',N'Tống Khánh Tân','2022/03/03'),
('127',N'Sàn Giao Dịch K','0345678910',N'222/Hai Bà Trưng/Q1',N'Lê Thanh Chú Bảy',N'Trưởng Phòng','0708091112',N'Nguyễn Vũ Trường Giang',N'Tống Khánh Tân','2022/01/01'),
('128',N'Sàn Giao Dịch H','0333333333',N'333/Bùi Viện/Q1',N'Nguyễn Thi Ngọc Bội ',N'Trưởng Phòng','0707878102',N'Trần Thanh Vy',N'Hồ Văn Đẹt','2022/02/02'),
('129',N'Sàn Giao Dịch G','0987654321',N'444/Nguyễn Huệ/Q2',N'Lê Quang ĐótKi',N'Trưởng Phòng','0708980802',N'Nguyễn Thúc Thùy Tiên',N'Hồ Văn Đẹt','2022/03/03'),
('130',N'Sàn Giao Dịch J','0345678910',N'222/Hai Bà Trưng/Q1',N'Lưu Vĩ Tâm Như',N'Trưởng Phòng','0708067543',N'Huỳnh Minh Nhựt',N'Nguyễn Thị Ngọc Hà','2022/01/01')

insert into SANPHAMDUAN
values ('SPDA201','DA01',N'Mặt Bằng Quận 1',N'12/Lê Lợi/Q.1','200','1412','2022/02/11',N'UBND Quận 1',N'Đất nền','NV04','2022/02/10','121'),
('SPDA202','DA02',N'Mặt Bằng Quận 2',N'121/Lê Duẫn /Q.2','150','1112','2022/03/12',N'UBND Quận 2',N'Đất chung cư','NV04','2022/03/10','122'),
('SPDA203','DA03',N'Mặt Bằng Quận 3',N'122/12/Thái Linh/Q.3','100','1314','2022/04/12',N'UBND Quận 3',N'Đất nền','NV08','2022/04/12','123'),
('SPDA204','DA04',N'Mặt Bằng Quận 1',N'20/Bùi Viện/Q.1','70','1019','2022/03/11',N'UBND Quận 1',N'Đất chung cư','NV09','2022/03/10','124'),
('SPDA205','DA05',N'Mặt Bằng Quận 4',N'301/Lê Lai/Q.4','120','14718','2022/01/11',N'UBND Quận 4',N'Đất mặt tiền','NV07','2022/01/10','125'),
('SPDA206','DA06',N'Mặt Bằng Quận 5',N'1200/Hai Bà Nhị/Q.5','100','1111','2022/02/12',N'UBND Quận 5',N'Đất nền','NV05','2022/02/03','126'),
('SPDA207','DA07',N'Mặt Bằng Quận 7',N'111/Phạm Huy Trích/Q.7','200','5112','2022/02/09',N'UBND Quận 7',N'Đất mặt tiền','NV03','2022/03/10','127'),
('SPDA208','DA08',N'Mặt Bằng Quận 8',N'192/Nguyễn Thái Sơn/Q.8','500','1612','2022/04/08',N'UBND Quận 8',N'Đất nền','NV04','2022/04/03','128'),
('SPDA209','DA09',N'Mặt Bằng Quận 10',N'120/Trần Hưng Đạo/Q.10','200','1902','2022/03/03',N'UBND Quận 10',N'Đất mặt tiền','NV07','2022/03/04','129'),
('SPDA210','DA010',N'Mặt Bằng Quận 1',N'12/Hàm Nghi/Q.1','250','1997','2022/02/06',N'UBND Quận 1',N'Đất nền','NV10','2022/02/08','130')

insert into QUANLYDUAN
values ('DA01','2022/02/11',N'Mặt Bằng Quận 1',N'12/Lê Lợi/Q.1','200','1412','2022/02/10',N'UBND Quận 1',N'Đất nền','NV04'),
('DA02','2022/03/12',N'Mặt Bằng Quận 2',N'121/Lê Duẫn /Q.2','150','1112','2022/03/10',N'UBND Quận 2',N'Đất chung cư','NV04'),
('DA03','2022/04/12',N'Mặt Bằng Quận 3',N'122/12/Thái Linh/Q.3','100','1314','2022/04/12',N'UBND Quận 3',N'Đất nền','NV08'),
('DA04','2022/03/11',N'Mặt Bằng Quận 1',N'20/Bùi Viện/Q.1','70','1019','2022/03/10',N'UBND Quận 1',N'Đất chung cư','NV09'),
('DA05','2022/01/11',N'Mặt Bằng Quận 4',N'301/Lê Lai/Q.4','120','14718','2022/01/10',N'UBND Quận 4',N'Đất mặt tiền','NV07'),
('DA06','2022/02/12',N'Mặt Bằng Quận 5',N'1200/Hai Bà Nhị/Q.5','100','1111','2022/02/03',N'UBND Quận 5',N'Đất nền','NV05'),
('DA07','2022/03/09',N'Mặt Bằng Quận 7',N'111/Phạm Huy Trích/Q.7','200','5112','2022/03/10',N'UBND Quận 7',N'Đất mặt tiền','NV03'),
('DA08','2022/04/08',N'Mặt Bằng Quận 8',N'192/Nguyễn Thái Sơn/Q.8','500','1612','2022/04/03',N'UBND Quận 8',N'Đất nền','NV04'),
('DA09','2022/03/03',N'Mặt Bằng Quận 10',N'120/Trần Hưng Đạo/Q.10','200','1902','2022/03/04',N'UBND Quận 10',N'Đất mặt tiền','NV07'),
('DA010','2022/02/06',N'Mặt Bằng Quận 1',N'12/Hàm Nghi/Q.1','250','1997','2022/02/08',N'UBND Quận 1',N'Đất nền','NV10')

insert into CONGNO
values ('KH001',N'Lê Công Vinh','GD01',N'Mặt Bằng Quận 1','2000000000','1','2000000000','500000000','1500000000','3','3','200000000'),
('KH002',N'Nguyễn Văn Toản','GD02',N'Mặt Bằng Quận 2','1300000000','1','1300000000','700000000','500000000','1','1','100000000'),
('KH003',N'Trần Thị Thanh Thảo','GD03',N'Mặt Bằng Quận 3','800000000','1','800000000','800000000','0','1','1','100000000'),
('KH004',N'Mạc Văn Khoa','GD04',N'Mặt Bằng Quận 1','500000000','1','500000000','500000000','0','1','1','100000000'),
('KH005',N'Trần Thanh Tâm','GD05',N'Mặt Bằng Quận 4','2000000000','1','2000000000','100000000','1000000000','3','3','200000000'),
('KH006',N'Bành Thị Bé Tư','GD06',N'Mặt Bằng Quận 5','100000000','1','1000000000','500000000','500000000','3','3','200000000'),
('KH007',N'Lê Thanh Chú Bảy','GD07',N'Mặt Bằng Quận 7','200000000','1','2000000000','500000000','1500000000','3','3','200000000'),
('KH008',N'Nguyễn Thị Ngọc Bội','GD08',N'Mặt Bằng Quận 8','3000000000','1','3000000000','200000000','1000000000','1','1','100000000'),
('KH009',N'Lê Quang ĐótKi','GD09',N'Mặt Bằng Quận 10','100000000','1','1000000000','100000000','0','1','1','100000000'),
('KH010',N'Lưu Vĩ Tâm Như','GD10',N'Mặt Bằng Quận 1','3000000000','1','3000000000','2000000000','1000000000','3','3','200000000')


