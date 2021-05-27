/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class NhanVienDTO {
    private String maNV, hoTen;
    private int sDT;
    private String  diaChi;
    private int maLoaiNV;
    private int luongCoBan;
    private String gioitinh;
    private String ngaySinh;
    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String hoTen, int sDT, String ngaySinh, String diaChi, int maLoaiNV, int luongCoBan, String gioitinh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.sDT = sDT;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maLoaiNV = maLoaiNV;
        this.luongCoBan = luongCoBan;
        this.gioitinh = gioitinh;
    }

    public int getsDT() {
        return sDT;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public int getMaLoaiNV() {
        return maLoaiNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

  
    public void setsDT(int sDT) {
        this.sDT = sDT;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void setMaLoaiNV(int maLoaiNV) {
        this.maLoaiNV = maLoaiNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }


    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }


    @Override
    public String toString() {
        if (this != null && maNV != null) {
            return "" + maLoaiNV;
        } else {
            return "" + maLoaiNV;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVienDTO other = (NhanVienDTO) obj;
        if (!Objects.equals(this.maNV, other.maNV)) {
            return false;
        }
        return true;
    }

    
}
