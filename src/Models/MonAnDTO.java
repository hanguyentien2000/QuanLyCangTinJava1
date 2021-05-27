/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Admin
 */
public class MonAnDTO {
    private int maMon;
    private String tenMon, dVT;
    private int maLoai, donGia;

    public MonAnDTO() {
    }

    public MonAnDTO(int maMon, String tenMon, String dVT, int maLoai, int donGia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.dVT = dVT;
        this.maLoai = maLoai;
        this.donGia = donGia;
    }



    public String getTenMon() {
        return tenMon;
    }

    public String getdVT() {
        return dVT;
    }

    public int getDonGia() {
        return donGia;
    }

    public int getMaMon() {
        return maMon;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setdVT(String dVT) {
        this.dVT = dVT;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }



}
