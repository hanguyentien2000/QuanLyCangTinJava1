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
public class BanDTO {
    private String  tenBan, trangThai;
    private int maBan;
    
    public BanDTO(){
        this.maBan =0;
        this.tenBan = "";
        this.trangThai = "";
    }
    public BanDTO(int ma, String ten, String trangthai){
        this.maBan = ma;
        this.tenBan = ten;
        this.trangThai = trangthai;
    }
    
    public void SetMaBan(int ma){
        this.maBan = ma;
    }
    public int GetMaBan(){
        return this.maBan;
    }
    public void SetTenBan(String ten){
        this.tenBan = ten;
    }
    public String GetTenBan(){
        return this.tenBan;
    }
    public void SetTrangThai(String trangthai){
        this.trangThai = trangthai;
    }
    public String GetTrangThai(){
        return this.trangThai;
    }
    @Override
    public String toString(){
        return this.tenBan;
    }
}
