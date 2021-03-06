use master
go
create database QuanLyCangTinSo2
go
USE [QuanLyCangTinSo2]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[MaBan] [int] IDENTITY(1,1) NOT NULL,
	[TenBan] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChamCong]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChamCong](
	[MaNhanVien] [nchar](10) NOT NULL,
	[Ngay] [date] NOT NULL,
	constraint PK_Chamcong primary key (Ngay, MaNhanVien),
	constraint Fk_Chamcong foreign key (MaNhanVien) references NhanVien(MaNhanVien)
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaChiTietHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NULL,
	[MaMon] [int] NULL,
	[SoLuong] [int] NULL,
	[GhiChu] [nvarchar](500) NULL,
 CONSTRAINT [PK_CTHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucMonAn]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucMonAn](
	[MaLoai] [int] IDENTITY(1,1) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[MaBan] [int] NULL,
	[Gioden] [datetime] NULL,
	[TrangThai] [bit] NULL,
	[TongTien] [int] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiNhanVien]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNhanVien](
	[MaLoaiNV] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiNV] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MonAn]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MonAn](
	[MaMon] [int] IDENTITY(1,1) NOT NULL,
	[TenMon] [nvarchar](50) NULL,
	[DVT] [nvarchar](50) NULL,
	[MaLoai] [int] NULL,
	[DonGia] [int] NULL,
 CONSTRAINT [PK_Mon] PRIMARY KEY CLUSTERED 
(
	[MaMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [nchar](10) NOT NULL,
	[Hoten] [nvarchar](50) NULL,
	[Sdt] [char](12) NULL,
	[Ngaysinh] [date] NULL,
	[Diachi] [nvarchar](50) NULL,
	[MaLoaiNV] [int] NULL,
	[LuongCoBan] [int] NULL,
	[GioiTinh] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Taikhoan]    Script Date: 5/26/2021 3:42:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Taikhoan](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NULL,
	[Quantri] [bit] NULL,
	[MaNhanVien] [nchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [Gioden]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [Fk_CTHoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [Fk_CTHoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [Fk_CTHoaDon1] FOREIGN KEY([MaMon])
REFERENCES [dbo].[MonAn] ([MaMon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [Fk_CTHoaDon1]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [Fk_HoaDon] FOREIGN KEY([MaBan])
REFERENCES [dbo].[Ban] ([MaBan])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [Fk_HoaDon]
GO
ALTER TABLE [dbo].[MonAn]  WITH CHECK ADD  CONSTRAINT [FK_Mon] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[DanhMucMonAn] ([MaLoai])
GO
ALTER TABLE [dbo].[MonAn] CHECK CONSTRAINT [FK_Mon]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [fk_nhanvien] FOREIGN KEY([MaLoaiNV])
REFERENCES [dbo].[LoaiNhanVien] ([MaLoaiNV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [fk_nhanvien]
GO
ALTER TABLE [dbo].[Taikhoan]  WITH CHECK ADD  CONSTRAINT [Fk_TaiKhoan] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Taikhoan] CHECK CONSTRAINT [Fk_TaiKhoan]
GO


INSERT INTO DanhMucMonAn (TenLoai) VALUES
( N'Cà phê'),
( N'Nước đóng chai'),
( N'Nước ngọt')

INSERT INTO ban (TenBan, TrangThai) VALUES
(N'Bàn 1', N'Đã Đặt trước'),
( N'Bàn 2', N'Đang phục vụ'),
( N'Bàn 3', N'Trống'),
( N'Bàn 4', N'Đã đặt trước'),
(N'Bàn 5', N'Trống'),
( N'Bàn 6', N'Trống'),
( N'Bàn 7', N'Trống')
go
INSERT INTO hoadon ( MaBan, Gioden, TrangThai, TongTien) VALUES
(1, '2021-02-17 19:44:48',1, 30000),
(2, '2021-02-17 19:44:48',1, 90000)
go
INSERT INTO MonAn ( TenMon,DVT, MaLoai, DonGia ) VALUES
(N'Nâu đá', 'Ly', 1, 25000),
(N'Nâu nóng', 'Ly', 2,  25000),
(N'Sữa', 'Ly', 1, 50000),
(N'Trà đào cam xả', 'Xô', 1, 40000)
go

insert into LoaiNhanVien values (N'Bồi bàn')
insert into LoaiNhanVien values (N'Phục vụ')
insert into LoaiNhanVien values (N'Bếp')
go


insert into NhanVien Values ('NV01', N'Đỗ Bá Hoàn', 0931283281, '09/28/2000', N'Tân lập', 2, 100000, N'Nam')
insert into NhanVien Values ('NV02', N'Nguyễn Tiến Hà', 0931283282, '04/03/2000', N'Cổ Nhuế', 3, 200000,  N'Nam')
insert into NhanVien Values ('NV03', N'Quách Ngọc Hà', 0931283283, '04/05/2000', N'Hoàng Mike', 3, 120000, N'Nam')


insert into Taikhoan values ('admin', 'admin', 1,'NV01')
insert into Taikhoan values ('nhanvien1', 'nhanvien', 0,'NV01')
insert into Taikhoan values ('nhanvien2', 'nhanvien', 0,'NV02')
insert into Taikhoan values ('nhanvien3', 'nhanvien', 0,'NV03')

insert into ChamCong values ('NV01', '2021-01-05')
insert into ChamCong values ('NV02', '2021-01-05')
insert into ChamCong values ('NV03', '2021-01-05')
insert into ChamCong values ('NV01', '2021-02-05')
insert into ChamCong values ('NV02', '2021-02-05')
insert into ChamCong values ('NV03', '2021-02-05')
insert into ChamCong values ('NV01', '2021-03-05')
insert into ChamCong values ('NV02', '2021-03-05')
insert into ChamCong values ('NV03', '2021-03-05')
insert into ChamCong values ('NV01', '2021-04-05')
insert into ChamCong values ('NV02', '2021-04-05')