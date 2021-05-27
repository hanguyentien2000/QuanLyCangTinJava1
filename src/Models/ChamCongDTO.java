/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ChamCongDTO {
    private String maNV;
    private Date ngay;

    public ChamCongDTO() {
    }

    public ChamCongDTO(String maNV, Date ngay) {
        this.maNV = maNV;
        this.ngay = ngay;
    }

    public String getMaNV() {
        return maNV;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}

