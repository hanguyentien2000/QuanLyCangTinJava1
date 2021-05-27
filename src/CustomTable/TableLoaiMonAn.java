/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.LoaiMonAnDTO;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableLoaiMonAn extends AbstractTableModel{
    private String name[]={"Mã loại","Tên loại"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={int.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<LoaiMonAnDTO> arrLoai = new ArrayList<LoaiMonAnDTO>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public TableLoaiMonAn()
    {
       this.arrLoai = StoreData.dsLoai;
    }

    @Override
    public int getRowCount()
    {
        return arrLoai.size();
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
            case 0: return Integer.toString(arrLoai.get(rowIndex).getMaLoai());
            case 1: return arrLoai.get(rowIndex).getTenLoai();
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
