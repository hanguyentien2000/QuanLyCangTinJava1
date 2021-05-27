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
public class LoaiMonAnDTO {
    private int maLoai;
    private String tenLoai;

    public LoaiMonAnDTO() {
    }

    public LoaiMonAnDTO(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }



    @Override
    public String toString() {
        if (this != null && maLoai != 0) {
            return maLoai + "-" + tenLoai;
        } else {
            return tenLoai;
        }
    }
//
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
        final LoaiMonAnDTO other = (LoaiMonAnDTO) obj;
        if (this.maLoai != other.maLoai) {
            return false;
        }
        return true;
    }

    
}
