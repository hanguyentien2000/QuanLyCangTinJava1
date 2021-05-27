/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author admin
 */
//Models chứa dữ liệu của 2 bảng CTHD và MonAn
public class DsOrder {
    private String tenMon, dVT, ghichu; 
    private int donGia, soLuong, maHoaDon, maMon;
    
    public DsOrder(){
        tenMon  = dVT = "";
        donGia = soLuong = maHoaDon = maMon= 0;
    }
    public DsOrder(int mamon, String tenmon, String dvt, int soluong, int gia, int mahd, String ghichu){
        maMon = mamon;
        maHoaDon = mahd;
        tenMon = tenmon;
        dVT = dvt;
        donGia = gia;
        soLuong = soluong;
        ghichu = ghichu;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getdVT() {
        return dVT;
    }

    public String getGhichu() {
        return ghichu;
    }

    public int getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setdVT(String dVT) {
        this.dVT = dVT;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    
    public int tongTien(){
        return soLuong * donGia;
    }
}
