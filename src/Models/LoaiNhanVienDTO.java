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
public class LoaiNhanVienDTO {

    private String tenLoaiNV;
    private int maLoaiNV;

    public LoaiNhanVienDTO() {
    }

    public LoaiNhanVienDTO(String tenLoaiNV, int maLoaiNV) {
        this.tenLoaiNV = tenLoaiNV;
        this.maLoaiNV = maLoaiNV;
    }

    public String getTenLoaiNV() {
        return tenLoaiNV;
    }

    public int getMaLoaiNV() {
        return maLoaiNV;
    }



   @Override
    public String toString() {
        if (this != null && maLoaiNV != 0) {
            return  "" + tenLoaiNV;
        } else {
            return tenLoaiNV;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.maLoaiNV;
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
        final LoaiNhanVienDTO other = (LoaiNhanVienDTO) obj;
        if (this.maLoaiNV != other.maLoaiNV) {
            return false;
        }
        return true;
    }

    
    
}
