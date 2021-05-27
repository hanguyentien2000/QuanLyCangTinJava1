/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import Models.TaiKhoanDTO;
import Models.BanDTO;
import Models.ChamCongDTO;
import Models.DsOrder;
import Models.HoaDonDTO;
import Models.LoaiMonAnDTO;
import Models.LoaiNhanVienDTO;
import Models.MonAnDTO;
import Models.NhanVienDTO;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StoreData {
     public static ArrayList<HoaDonDTO> dsHD;
     public static ArrayList<MonAnDTO> dsMon;
     public static ArrayList<TaiKhoanDTO> dsTK;
     public static ArrayList<BanDTO> dsBan;
     public static ArrayList<LoaiMonAnDTO> dsLoai;
     public static ArrayList<NhanVienDTO> dsNV;
     public static ArrayList<ChamCongDTO> dsCC;
     public static ArrayList<LoaiNhanVienDTO> dsLNV;
     public static ArrayList<DsOrder> dsOders;
     public static MonAnDTO currentMonAn;
     public static LoaiMonAnDTO currentLoai;
     public static BanDTO currentBan;
     public static TaiKhoanDTO currentAccount;
     public static HoaDonDTO currentHoaDon;
     public static NhanVienDTO currentNhanVien;
     public static LoaiNhanVienDTO currentLoaiNV;
     public static DsOrder currentOrders;
}
