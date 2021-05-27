/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.LoaiMonAnDTO;
import Models.MonAnDTO;
import SQLConnect.ConnectSQL;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableMon extends AbstractTableModel{
    private String name[]={"Mã món","Tên món","Tên loại","Đơn giá", "Đơn vị tính"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class, String.class,int.class, String.class};
    ConnectSQL con = new ConnectSQL();
    ArrayList<MonAnDTO> arrMon = new ArrayList<MonAnDTO>();
    ArrayList<LoaiMonAnDTO> arrLoaiMon = con.GetAllLoaiMonAn();
    public TableMon() {
        this.arrMon = StoreData.dsMon;
    }
    
    @Override
    public int getRowCount() {
         return arrMon.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return arrMon.get(rowIndex).getMaMon();
            case 1: return arrMon.get(rowIndex).getTenMon();
            case 2:
                String tenloaimon = "";
                for(int i=0; i<arrLoaiMon.size(); i++){
                    if(arrLoaiMon.get(i).getMaLoai()==arrMon.get(rowIndex).getMaLoai())
                        tenloaimon = arrLoaiMon.get(i).getTenLoai();
                }
                return tenloaimon;
//                return arrMon.get(rowIndex).getMaLoai();
            case 3: return Integer.toString(arrMon.get(rowIndex).getDonGia());
            case 4: return arrMon.get(rowIndex).getdVT();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return name[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
