/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.TaiKhoanDTO;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableTaiKhoan extends AbstractTableModel{
    private String name[]={"Tên tài khoản","Mật khẩu","Quản trị", "Mã NV"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class, String.class, String.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<TaiKhoanDTO> arrTK = new ArrayList<TaiKhoanDTO>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public TableTaiKhoan()
    {
       this.arrTK = StoreData.dsTK;
    }

    @Override
    public int getRowCount()
    {
        return arrTK.size();
    }

    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return arrTK.get(rowIndex).getUsername();
            case 1: return arrTK.get(rowIndex).getPassword();
            case 2: return arrTK.get(rowIndex).getAdmin()? "Admin" : "Nhân viên";
            case 3: return arrTK.get(rowIndex).getManv();
            default :return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
