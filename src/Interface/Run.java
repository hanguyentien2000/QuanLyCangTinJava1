/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.TaiKhoanDTO;

public class Run {
    public static Main QlCangTin;
    public static LoginNewFrm frmlg = new LoginNewFrm();
    public static TaiKhoanDTO account;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        login();
    }
    public static void login(){
        frmlg = new LoginNewFrm();
        frmlg.setVisible(true);       
    }  
    public static void QLCanTeen(){
        QlCangTin = new Main();
        QlCangTin.setVisible(true);       
    }
}
