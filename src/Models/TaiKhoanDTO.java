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
public class TaiKhoanDTO {
//    private int id;
    private String userName, maNV;
    private String passWord;
    private Boolean admin;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String username, String password, Boolean admin, String manv) {
        this.userName = username;
        this.passWord = password;
        this.admin = admin;
        this.maNV = manv;

    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getManv() {
        return maNV;
    }

    public void setManv(String manv) {
        this.maNV = manv;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
