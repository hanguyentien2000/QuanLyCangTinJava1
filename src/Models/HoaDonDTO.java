/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author HaNT
 */
public class HoaDonDTO {
    private int maHoaDon, maBan;
    private String gioDen;
    private Boolean trangThai;
    private int tongTien;
    
    public HoaDonDTO() {
    }

    public HoaDonDTO(int maHoaDon, int maBan, String gioDen, Boolean trangThai, int tongTien) {
        this.maHoaDon = maHoaDon;
        this.maBan = maBan;
        this.gioDen = gioDen;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaBan() {
        return maBan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public String getGioDen() {
        return gioDen;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }


    public void setGioDen(String gioDen) {
        this.gioDen = gioDen;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

}