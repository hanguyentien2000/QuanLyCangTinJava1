/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author HaNT
 */
public class ChiTietHoaDonDTO {
    private int maChiTietHD, maHoaDon, soLuong;
    
    private int maMon;
    private String ghiChu;

    public ChiTietHoaDonDTO() {
    }

    public ChiTietHoaDonDTO(int maChiTietHD, int maHoaDon, int maMon, int soLuong, String ghiChu) {
        this.maChiTietHD = maChiTietHD;
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
        this.maMon = maMon;
        this.ghiChu = ghiChu;
    }

    public int getMaChiTietHD() {
        return maChiTietHD;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }


    public int getMaMon() {
        return maMon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaChiTietHD(int maChiTietHD) {
        this.maChiTietHD = maChiTietHD;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{" + "maChiTietHD=" + maChiTietHD + ", maHoaDon=" + maHoaDon + ", soLuong=" + soLuong + ", maMon=" + maMon + ", ghiChu=" + ghiChu + '}';
    }


}
