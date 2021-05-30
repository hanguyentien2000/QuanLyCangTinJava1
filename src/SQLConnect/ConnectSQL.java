package SQLConnect;

import Interface.QuanLy.JpQuanLyBan;
import Interface.QuanLy.JpQuanLyLoaiMonAn;
import Interface.QuanLy.JpQuanLyMonAn;
import Interface.QuanLy.JpQuanLyNhanVien;
import Interface.QuanLy.JpQuanLyTaiKhoan;
import Models.BanDTO;
import Models.ChiTietHoaDonDTO;
import Models.DsOrder;
import Models.HoaDonDTO;
import Models.LoaiMonAnDTO;
import Models.TaiKhoanDTO;
import Models.ChamCongDTO;
import Models.LoaiNhanVienDTO;
import Models.MonAnDTO;
import Models.NhanVienDTO;
import Store.StoreData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

public class ConnectSQL {

    private Connection con;
    PreparedStatement pst;
    CallableStatement cs;

    public ConnectSQL() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuanLyCangTinSo2", "sa", "1qaz2wsx3");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kết nối thất bại !");
        }
    }

    ///set prepared statement 
    private void setParameters(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int j = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(j, (Long) parameter);
                }
                if (parameter instanceof String) {
                    statement.setString(j, (String) parameter);
                }
                if (parameter instanceof Timestamp) {
                    statement.setTimestamp(j, (Timestamp) parameter);
                }
                if (parameter instanceof Integer) {
                    statement.setInt(j, (Integer) parameter);
                }
                if (parameter == null) {
                    statement.setNull(j, Types.NULL);
                }
                if (parameter instanceof Boolean) {
                    statement.setBoolean(j, (Boolean) parameter);
                }
                if (parameter instanceof Date) {
                    statement.setDate(j, (Date) parameter);
                }
                if (parameter instanceof Double) {
                    statement.setDouble(j, (Double) parameter);
                }
                if (parameter instanceof Float) {
                    statement.setFloat(j, (Float) parameter);
                }
            }
        } catch (SQLException ex) {
        }
    }

    //Region LoaiMonAn
    public ArrayList<LoaiMonAnDTO> GetAllLoaiMonAn() {
        ArrayList<LoaiMonAnDTO> arrloai = null;
        String sql = "Select * From DanhMucMonAn";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            arrloai = new ArrayList<LoaiMonAnDTO>();
            while (rs.next()) {
                LoaiMonAnDTO sp = new LoaiMonAnDTO(rs.getInt(1), rs.getString(2));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được loại món ăn !");
        }
        return arrloai;
    }

    public String GetMaLoaiByName(String TenLoaiMonAn) {
        String maloai = null;
        String sql = "Select MaLoai From DanhMucMonAn Where TenLoai = '" + TenLoaiMonAn + "'";
        try {
            //Khởi tạo đối tượng thực thi câu lệnh
            Statement st = con.createStatement();
            //Thực thi câu lệnh
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maloai = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được mã loại món ăn !");
        }
        return maloai;
    }

    public int InsertLoaiMon(LoaiMonAnDTO loai) {
        int insert = 0;
        String sql = "Insert into DanhMucMonAn values(?)";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, loai.getTenLoai());
            insert = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại!");
        }
        return insert;
    }

    public int DeleteLoai(int maloai) {
        int del = 0;
        try {
            String sql = "Delete From DanhMucMonAn Where MaLoai = " + maloai + "";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            StoreData.dsLoai = GetAllLoaiMonAn();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
        return del;
    }

    public String TimLoai(String tenloai) {
        String sql;
        if (tenloai.trim().equals("")) {
            sql = "select *from DanhMucMonAn";
        } else {
            sql = "Select * From DanhMucMonAn Where TenLoai LIKE N'" + tenloai + "%'";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
                return null;
            }
            StoreData.dsLoai.clear();
            while (rs.next()) {
                LoaiMonAnDTO loai = new LoaiMonAnDTO();
                loai.setMaLoai(rs.getInt(1));
                loai.setTenLoai(rs.getString(2));
                StoreData.dsLoai.add(loai);
            }
            JpQuanLyLoaiMonAn.loai.loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không tìm được loại món ăn");
        }
        return tenloai;
    }

    public LoaiMonAnDTO GetLoaiByMa(int maloai) {
        LoaiMonAnDTO loai = null;
        String sql = "Select * From DanhMucMonAn Where MaLoai = " + maloai + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                loai = new LoaiMonAnDTO(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được loại theo mã");
        }
        return loai;
    }

    public int UpdateLoai(LoaiMonAnDTO loai) {
        int update = 0;
        String sql = "Update DanhMucMonAn set TenLoai = ? Where MaLoai = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, loai.getTenLoai(), loai.getMaLoai());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update Loại không thành công !");
        }
        return update;
    }

    ///---------------------------------
    ////EndRegionLoaiMonAn
    ///RegionBanAn
    public ArrayList<BanDTO> GetAllBan(int maban) {
        ArrayList<BanDTO> arrBan = null;
        String sql;
        if (maban == 0) {
            sql = "Select * From Ban";
        } else {
            sql = "Select * From Ban Where MaBan = " + maban + "";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<BanDTO>();
            while (rs.next()) {
                BanDTO ban = new BanDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(ban);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách bàn !");
        }
        return arrBan;
    }

    public int UpdateBan(BanDTO b) {
        int update = 0;
        String sql = "Update Ban set TenBan = ?, TrangThai = ? Where MaBan = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, b.GetTenBan(), b.GetTrangThai(), b.GetMaBan());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }

    public int UpDateTrangThaiBan(BanDTO ban) {
        int update = 0;
        String sql = "Update Ban set TrangThai = ? Where MaBan = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, ban.GetTrangThai(), ban.GetMaBan());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;
    }

    public int InsertBan(BanDTO b) {
        int insert = 0;
        String sql = "Insert into Ban values (?,?)";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, b.GetTenBan(), b.GetTrangThai());
            insert = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại!");
        }
        return insert;
    }

    public String TimBan(String tenban) {
        String sql;
        if (tenban.trim().equals("")) {
            sql = "Select * from Ban";
        } else {
            sql = "Select * From Ban Where TenBan LIKE N'" + tenban + "%'";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
                return null;
            }
            StoreData.dsBan.clear();
            while (rs.next()) {
                BanDTO ban = new BanDTO();
                ban.SetMaBan(rs.getInt(1));
                ban.SetTenBan(rs.getString(2));
                ban.SetTrangThai(rs.getString(3));
                StoreData.dsBan.add(ban);
            }
            JpQuanLyBan.ban.loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy bàn");
        }
        return tenban;
    }

    public int DeleteBan(int maban) {
        int del = 0;
        try {
            String sql = "Delete From Ban Where MaBan = " + maban + "";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            StoreData.dsBan = GetAllBan(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Bàn đang được sử dụng! Xin vui lòng chuyển trạng thái bàn để xoá!");
        }
        return del;
    }

    ///-------------------------------------------------------
    ///EndRegionBanAn
    ///Region Mon An
    public ArrayList<MonAnDTO> GetMonAnById(int ma) {
        ArrayList<MonAnDTO> arrThucDon = null;
        String sql = "Select * From MonAn Where MaMon = " + ma + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<MonAnDTO>();
            while (rs.next()) {
                MonAnDTO td = new MonAnDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được món ăn theo mã");
        }
        return arrThucDon;
    }

    public ArrayList<MonAnDTO> GetAllMon(String ma) {
        ArrayList<MonAnDTO> arrThucDon = null;
        String sql;
        if (ma == null) {
            sql = "Select * From MonAn";
        } else {
            sql = "Select * From MonAn Where MaLoai = " + ma + "";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<MonAnDTO>();
            while (rs.next()) {
                MonAnDTO td = new MonAnDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        return arrThucDon;
    }

    public ArrayList<DsOrder> GetDsOrder(int ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select ChiTietHoaDon.MaMon, TenMon, DVT, SoLuong, DonGia, ChiTietHoaDon.MaHD, GhiChu From ChiTietHoaDon INNER JOIN MonAn ON ChiTietHoaDon.MaMon = MonAn.MaMon INNER JOIN HoaDon ON ChiTietHoaDon.MaHD = HoaDon.MaHD Where ChiTietHoaDon.MaHD = " + ma + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách orders!");
        }
        return arrDs;
    }

    public int InsertMon(MonAnDTO td) {
        int insert = 0;
        String sql = "Insert into MonAn (TenMon, MaLoai, DonGia, DVT) values (N'" + td.getTenMon() + "', '" + td.getMaLoai() + "', '" + td.getDonGia() + "', N'" + td.getdVT() + "')";
        try {
            Statement st = con.createStatement();
            insert = st.executeUpdate(sql);
//            StoreData.dsMon.add(td);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thêm được món ăn!");
        }
        return insert;
    }

    public int DeleteMon(int mamon) {
        int del = 0;
        try {
            String sql = "Delete From MonAn Where MaMon = " + mamon + "";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            StoreData.dsMon = GetDsMonAn();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không xoá được món");
        }
        return del;
    }

    public String TimMon(String tenmon) {
        String sql;
        if (tenmon.trim().equals("")) {
            sql = "Select * From MonAn";
        } else {
            sql = "Select * From MonAn Where TenMon LIKE N'" + tenmon + "%'";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
                return null;
            }
            StoreData.dsMon.clear();
            while (rs.next()) {
                MonAnDTO mon = new MonAnDTO();
                mon.setMaMon(rs.getInt(1));
                mon.setTenMon(rs.getString(2));
                mon.setMaLoai(rs.getInt(4));
                mon.setdVT(rs.getString(3));
                mon.setDonGia(rs.getInt(5));
                StoreData.dsMon.add(mon);
            }
            JpQuanLyMonAn.mon.loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return tenmon;
    }

    public boolean DeleteMon(ArrayList<String> listMamon) {
        boolean check = false;
        try {
            String sql;
            for (String ma : listMamon) {
                sql = "Delete From MonAn Where MaMon = '" + ma + "'";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {
        }
        return check;
    }

    public int UpdateMon(MonAnDTO td) {
        int update = 0;
        String sql = "Update MonAn set TenMon = ?, MaLoai = ?, DonGia = ?, DVT = ? Where MaMon = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, td.getTenMon(), td.getMaLoai(), td.getDonGia(), td.getdVT(), td.getMaMon());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cập nhật món thất bại");
        }
//        JOptionPane.showMessageDialog(null, update + td.getMaMon());
        return update;
    }

    public ArrayList<MonAnDTO> GetDsMonAn() {
        ArrayList<MonAnDTO> arrDs = null;
        String sql = "Select * from MonAn";;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<MonAnDTO>();
            while (rs.next()) {
                MonAnDTO order = new MonAnDTO();
                order.setTenMon(rs.getString(2));
                order.setMaMon(rs.getInt(1));
                order.setdVT(rs.getString(3));
                order.setDonGia(rs.getInt(5));
                order.setMaLoai(rs.getInt(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Get DS món ăn thất bại!");
        }
        return arrDs;
    }

    public ArrayList<MonAnDTO> GetMonAnTheoLoai(int maloai) {
        ArrayList<MonAnDTO> arrDs = null;
        String sql = "SELECT MaMon,TenMon, DVT, MaLoai, DonGia FROM MonAn where MaLoai =" + maloai + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<MonAnDTO>();
            while (rs.next()) {
//                JOptionPane.showMessageDialog(null, "Vo");
                MonAnDTO order = new MonAnDTO();
                order.setMaMon(Integer.parseInt(rs.getString(1)));
                order.setTenMon(rs.getString(2));
                order.setdVT(rs.getString(3));
                order.setMaLoai(rs.getInt(4));
                order.setDonGia(rs.getInt(5));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrDs;
    }

    ///-------------------------------
    ///EndRegionMonAn
    ///RegionChiTietHoaDon
    public ArrayList<HoaDonDTO> GetHdByDate(String d1, String d2) {
        ArrayList<HoaDonDTO> arrDs = null;
        String sql = "Select * from HoaDon where GioDen between ? AND ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, d1);
            pst.setString(2, d2);
            ResultSet rs = pst.executeQuery();
            arrDs = new ArrayList<HoaDonDTO>();
            while (rs.next()) {
                HoaDonDTO order = new HoaDonDTO();
                order.setMaHoaDon(rs.getInt(1));
                order.setMaBan(rs.getInt(2));
                order.setGioDen(rs.getString(3));
                order.setTrangThai(rs.getBoolean(4));
                order.setTongTien(rs.getInt(5));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrDs;
    }

    public ChiTietHoaDonDTO GetDsChiTiet(int mamon, int maban) {
        ChiTietHoaDonDTO arrDs = null;
        String sql = "Select SoLuong, MaChiTietHD, GhiChu From ChiTietHoaDon INNER JOIN HoaDon ON ChiTietHoaDon.MaHD = HoaDon.MaHD Where MaMon = "
                + mamon + " AND MaBan = " + maban + " AND HoaDon.TrangThai = 0";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrDs = new ChiTietHoaDonDTO();
                arrDs.setSoLuong(rs.getInt(1));
                arrDs.setMaChiTietHD(rs.getInt(2));
                arrDs.setGhiChu(rs.getString(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrDs;
    }

    public int DeleteMonFromCTHD(int mamon, int mahd, int maban) {
        int check = 0;
        try {
            String sql = "Delete From ChiTietHoaDon Where MaMon = " + mamon + " AND MaHD = " + mahd + "";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if (CheckDsMon(mahd, maban) == 0) {
                check = 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xoá món không thành công");
        }
        return check;
    }

    public int UpdateChiTietHD(ChiTietHoaDonDTO ct) {
        int update = 0;
//        String sql = "UPDATE ChiTietHoaDon SET SoLuong = " + ct.getSoLuong() + " WHERE MaChiTietHD = " + ct.getMaCTHoaDon() + "";
//        String sql = "Update ChiTietHoaDon set SoLuong = '" + soluong + "', GhiChu = N'" + ghichu + "' Where MaChiTietHD = '" + macthd + "'";
        String sql = "Update ChiTietHoaDon set SoLuong = ?, GhiChu = ? Where MaChiTietHD = ?";
        try {
//            Statement st = con.createStatement();
//            update = st.executeUpdate(sql);
            pst = con.prepareStatement(sql);
            setParameters(pst, ct.getSoLuong(), ct.getGhiChu(), ct.getMaChiTietHD());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;
    }

    public int InsertChiTietHD(ChiTietHoaDonDTO cthd) {
        int insert = 0;
//        String sql = "Insert into ChiTietHoaDon (MaHD, MaMon, SoLuong, GhiChu) values (" + cthd.getMaHoaDon() + ", " + cthd.getMaMon() + ", " + cthd.getSoLuong() + ")";
        String sql = "Insert into ChiTietHoaDon values(?, ? ,?, ?)";

        try {
//            Statement st = con.createStatement();
//            insert = st.executeUpdate(sql);
            pst = con.prepareStatement(sql);
            setParameters(pst, cthd.getMaHoaDon(), cthd.getMaMon(), cthd.getSoLuong(), cthd.getGhiChu());
            insert = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hoá đơn không thành công!");
        }
        return insert;
    }

    public ArrayList<MonAnDTO> GetChiTietHoaDonByMaMon() {
        ArrayList<MonAnDTO> arrDs = null;
        String sql = "SELECT TenMon, MaMon, DVT FROM MonAn Where MaMon in (Select MaMon From ChiTietHoaDon)";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<MonAnDTO>();
            while (rs.next()) {
                MonAnDTO order = new MonAnDTO();
                order.setDonGia(rs.getInt(1));
                order.setMaMon(rs.getInt(2));
                order.setdVT(rs.getString(3));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<ChiTietHoaDonDTO> GetChiTietHoaDonByMaHD(int mahd) {
        ArrayList<ChiTietHoaDonDTO> arrCC = new ArrayList<>();
        String sql = "Select * From ChiTietHoaDon where MaHD = '" + mahd + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ChiTietHoaDonDTO cc = new ChiTietHoaDonDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
                arrCC.add(cc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KHÔNG lấy được danh sách chi tiết hóa đơn !");
        }
        return arrCC;
    }

    ///-------------------------------------------------
    ///EndRegionChiTietHoaDon
    ///RegionHoaHon
    ///-------------------------------------------------
    public int HuyHD(HoaDonDTO hd) {
        int delete = 0;
        String sql = "Delete From HoaDon Where MaHD = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, hd.getMaHoaDon());
            delete = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Huỷ hoá đơn không thành công !");
        }
        return delete;
    }

    public int ThanhToan(HoaDonDTO hd) {
        int update = 0;
        String sql = "Update HoaDon set TongTien = ?, TrangThai = 1 Where MaHD = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, hd.getTongTien(), hd.getMaHoaDon());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public int InsertHoaDon(HoaDonDTO hd, Timestamp gio) {
        int insert = 0;
        String sql = "Insert into HoaDon values(?, ? ,? ,?)";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, hd.getMaBan(), gio, hd.getTrangThai(), hd.getTongTien());
            insert = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm hoá đơn không thành công!");
        }
        return insert;
    }

    public int CheckDsMon(int mahd, int maban) {
        String sql = "Select * From HoaDon INNER JOIN ChiTietHoaDon ON ChiTietHoaDon.MaHD = HoaDon.MaHD Where MaBan = " + maban + " AND ChiTietHoaDon.MaHD = " + mahd + " AND TrangThai = 0";
        int dem = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dem++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dem;
    }

    public HoaDonDTO GetHDbyMaBan(int ma) {
        String sql = "Select * From HoaDon Where MaBan = " + ma + " AND TrangThai = 0";
        HoaDonDTO arrhd = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrhd = new HoaDonDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }

    public int GetMaHD(int ma) {
        String sql = "Select MaHD From HoaDon Where MaBan = " + ma + " AND TrangThai = 0";
        int mahd = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mahd = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được mã hoá đơn !");
        }
        return mahd;
    }

    public int UpdateHD(HoaDonDTO hd) {
        int update = 0;
        String sql = "Update HoaDon set MaBan = ?, Gioden = ?, TrangThai = ?, TongTien = ? where MaHD = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, hd.getMaBan(), hd.getGioDen(), hd.getTrangThai(), hd.getTongTien(), hd.getMaHoaDon());
            update = pst.executeUpdate();
            if (update < 1) {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cập nhật hoá đơn không thành công !");
        }
        return update;
    }

    public ArrayList<HoaDonDTO> GetHDThanhToan() {
        ArrayList<HoaDonDTO> arrDs = null;
        String sql = "Select * From HoaDon Where TrangThai = 1";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDonDTO>();
            while (rs.next()) {
                HoaDonDTO hoadon = new HoaDonDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
                arrDs.add(hoadon);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<HoaDonDTO> GetAllHD() {
        ArrayList<HoaDonDTO> arrDs = null;
        String sql = "Select * From HoaDon";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDonDTO>();
            while (rs.next()) {
                HoaDonDTO hoadon = new HoaDonDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
                arrDs.add(hoadon);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    ///------------------------------------------------
    ///EndRegionHoaDon
    ///
    ///RegionAccount
    public boolean CheckLogin(TaiKhoanDTO tk) {
        boolean check = false;
        String sql = "Select * From Taikhoan Where username = '" + tk.getUsername() + "' AND password='" + tk.getPassword() + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return check;
    }



    public boolean DeleteTaiKhoan(String username) {
        boolean check = false;
        try {
            String sql = "Delete From TaiKhoan Where Username='" + username + "'";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            check = true;
            StoreData.dsTK = GetAllTaiKhoan();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return check;
    }

    public int InsertTK(TaiKhoanDTO tk) {
        int insert = 0;
        String sql = "Insert into TaiKhoan values(?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, tk.getUsername(), tk.getPassword(), tk.getAdmin(), tk.getManv());
            insert = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
//            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return insert;
    }

    public ArrayList<TaiKhoanDTO> GetAllTaiKhoan() {
        ArrayList<TaiKhoanDTO> arrTk = null;
        String sql = "Select * From TaiKhoan";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            arrTk = new ArrayList<TaiKhoanDTO>();
            while (rs.next()) {
                TaiKhoanDTO sp = new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4));
                arrTk.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được tài khoản !");
        }
        return arrTk;
    }

    public TaiKhoanDTO GetTaiKhoan(String name, String pass) {
        TaiKhoanDTO td = null;
        String sql = "SELECT * FROM TaiKhoan Where username = '" + name + "' AND password='" + pass + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }

    public int UpdateTK(TaiKhoanDTO acc) {
        int update = 0;
        String sql = "Update TaiKhoan set Password = ?, QuanTri = ? where Username = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, acc.getPassword(), acc.getAdmin() ,acc.getUsername());
            update = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return update;
    }

    public String TimTaiKhoan(String username) {
        String sql;
        if (username.trim().equals("")) {
            sql = "Select * from TaiKhoan";
        } else {
            sql = "Select * From TaiKhoan Where Username LIKE '" + username + "%'";

        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
                return null;
            }
            StoreData.dsTK.clear();
            while (rs.next()) {
                TaiKhoanDTO ac = new TaiKhoanDTO();
                ac.setUsername(rs.getString(1));
                ac.setPassword(rs.getString(2));
                ac.setAdmin(rs.getBoolean(3));
                ac.setManv(rs.getString(4));
                StoreData.dsTK.add(ac);
            }
            JpQuanLyTaiKhoan.tk.loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return username;
    }

    ///------------------
    ///EndRegionTaiKhoan
    ///RegionNhanVien
    public ArrayList<ChamCongDTO> GetChamCong() {
        ArrayList<ChamCongDTO> arrCC = new ArrayList<>();
        String sql = "Select * From ChamCong";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamCongDTO cc = new ChamCongDTO(rs.getString(1), rs.getDate(2));
                arrCC.add(cc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KHÔNG lấy được danh sách Chấm Công !");
        }
        return arrCC;
    }

    public ArrayList<ChamCongDTO> GetChamCongByID(String manv) {
        ArrayList<ChamCongDTO> arrCC = new ArrayList<>();
        String sql = "Select * From ChamCong Where MaNhanVien = '" + manv + "'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamCongDTO cc = new ChamCongDTO(rs.getString(1), rs.getDate(2));
                arrCC.add(cc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KHÔNG lấy được danh sách Chấm Công !");
        }
        return arrCC;
    }

    public int InsertChamCong(String maNV, String ngay) {
        int insert = 0;
        String sql = "Insert into ChamCong (MaNhanVien, Ngay) values (N'" + maNV + "', '" + ngay + "')";
        try {
            Statement st = con.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ĐÃ chấm công ngày hôm nay !!!");
        }
        return insert;
    }

    public ArrayList<NhanVienDTO> GetAllNhanVien() {
        ArrayList<NhanVienDTO> arrNV = null;
        String sql = "Select *from NhanVien";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<NhanVienDTO>();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                arrNV.add(nv);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách nhân viên !");
        }
        return arrNV;
    }
    
      public ArrayList<String> GetAllNhanVienDaNghiNhungCoChamCong() {
        ArrayList<String> arrNV = null;
        String sql = "Select MaNhanVien from ChamCong group by MaNhanVien";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNV = new ArrayList<String>();
            while (rs.next()) {
                arrNV.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách nhân viên !");
//            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrNV;
    }

    public LoaiNhanVienDTO GetLoaiNVById(int maloai) {
        LoaiNhanVienDTO loai = null;
        String sql = "Select * From LoaiNhanVien Where MaLoaiNV = '" + maloai + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                loai = new LoaiNhanVienDTO(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return loai;
    }

    public NhanVienDTO CheckExistId(String Manv) {
        String sql = "Select * from NhanVien Where MaNhanVien = ?";
        NhanVienDTO nv;
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, Manv);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nv = new NhanVienDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                return nv;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public TaiKhoanDTO CheckExistIdAccount(String Manv) {
        String sql = "Select * from TaiKhoan where MaNhanVien = ?";
        TaiKhoanDTO acc;
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, Manv);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                acc = new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4));
                return acc;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public TaiKhoanDTO CheckExistUsernameAccount(String username) {
        String sql = "Select * from TaiKhoan where Username = ?";
        TaiKhoanDTO acc;
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                acc = new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4));
                return acc;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public int InsertNhanVien(NhanVienDTO nv) {
        int insert = 0;
        String sql = "Insert into NhanVien values(?, ?, ?, ? ,? ,? ,? ,?)";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, nv.getMaNV(), nv.getHoTen(), nv.getsDT(), nv.getNgaySinh(), nv.getDiaChi(), nv.getMaLoaiNV(), nv.getLuongCoBan(), nv.getGioitinh());
            insert = pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return insert;
    }

    public int UpdateNhanVien(NhanVienDTO nv) {
        int update = 0;
        String sql = "Update NhanVien Set HoTen = ?, DiaChi = ? ,Sdt = ?, NgaySinh = ?, MaLoaiNV = ?, LuongCoBan = ? ,GioiTinh = ? Where MaNhanVien = ?";
        try {
            pst = con.prepareStatement(sql);
            setParameters(pst, nv.getHoTen(), nv.getDiaChi(), nv.getsDT(), nv.getNgaySinh(), nv.getMaLoaiNV(), nv.getLuongCoBan(), nv.getGioitinh(), nv.getMaNV());
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return update;
    }

    public boolean DeleteNhanVien(String manv) {
        boolean check = false;
        try {
            String sql = "Delete From NhanVien Where MaNhanVien = '" + manv + "'";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            check = true;
            StoreData.dsNV = GetAllNhanVien();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return check;
    }

    public ArrayList<LoaiNhanVienDTO> GetAllLoaiNV() {
        ArrayList<LoaiNhanVienDTO> arrloai = null;
        String sql = "Select * From LoaiNhanVien";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            arrloai = new ArrayList<LoaiNhanVienDTO>();
            while (rs.next()) {
                LoaiNhanVienDTO nv = new LoaiNhanVienDTO(rs.getString(2), rs.getInt(1));
                arrloai.add(nv);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrloai;
    }

    public ArrayList<NhanVienDTO> GetNhanVienTheoMa(int maloai) {
        ArrayList<NhanVienDTO> arrNv = null;
        String sql = "SELECT MaNhanVien, HoTen, SDT, NgaySinh, DiaChi, MaLoaiNV, LuongCoBan, GioiTinh FROM NhanVien where MaLoaiNV ='" + maloai + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrNv = new ArrayList<NhanVienDTO>();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setsDT(rs.getInt(3));
                nv.setNgaySinh(rs.getString(4));
                nv.setDiaChi(rs.getString(5));
                nv.setMaLoaiNV(rs.getInt(6));
                nv.setLuongCoBan(rs.getInt(7));
                nv.setGioitinh(rs.getString(8));
                arrNv.add(nv);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrNv;
    }


    public String TimNhanVien(String tennv) {
        String sql;
        if (tennv.trim().equals("")) {
            sql = "select *From NhanVien";
        } else {
            sql = "Select * From NhanVien Where HoTen LIKE N'" + tennv + "%'";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
                return null;

            }
            StoreData.dsNV.clear();
            JpQuanLyNhanVien.nv.loadData();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setsDT(rs.getInt(3));
                nv.setNgaySinh(rs.getString(4));
                nv.setDiaChi(rs.getString(5));
                nv.setMaLoaiNV(rs.getInt(6));
                nv.setLuongCoBan(rs.getInt(7));
                nv.setGioitinh(rs.getString(8));
                StoreData.dsNV.add(nv);
            }
            JpQuanLyNhanVien.nv.loadData();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return tennv;
    }
    
    
    public NhanVienDTO GetMaLoaiNV(int maloai) {
        NhanVienDTO nv = null;
        String sql = "Select * From NhanVien Where MaLoaiNV = " + maloai + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                nv = new NhanVienDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return nv;
    }

    public ArrayList<ChamCongDTO> GetChamCongByDate(String manv, String s1, String s2) {
        ArrayList<ChamCongDTO> arrCCByDate = null;
        String sql = "Select * From ChamCong Where MaNhanVien = '" + manv + "' And (Ngay >= '" + s1 + "') And (Ngay <= '" + s2 + "')";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrCCByDate = new ArrayList<ChamCongDTO>();
            while (rs.next()) {
                ChamCongDTO cc = new ChamCongDTO(rs.getString(1), rs.getDate(2));
                arrCCByDate.add(cc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KHÔNG lấy được danh sách Chấm Công !");
        }
        return arrCCByDate;
    }
    
    public boolean DeleteChamCongByMaNV(String maNV){
        boolean check = false;
        try {
            String sql = "Delete From dbo.ChamCong Where MaNhanVien = '" + maNV + "'";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            check = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return check;
    }
    ///EndRegionNhanVien
}
