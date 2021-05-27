/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.MonAnDTO;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableGoiMon extends AbstractTableModel{
    private String name[]={"Tên món", "Đơn giá"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class, int.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<MonAnDTO> arrCC = new ArrayList<MonAnDTO>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public TableGoiMon()
    {
       this.arrCC = StoreData.dsMon;
    }

    public TableGoiMon(ArrayList<MonAnDTO> arrThucDon) {
        this.arrCC = arrThucDon;
    }

    @Override
    public int getRowCount()
    {
        return arrCC.size();
    }

    @Override
    public int getColumnCount()
    {
        return name.length;
    }


    
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return arrCC.get(rowIndex).getTenMon().toString();
            case 1: return Integer.toString(arrCC.get(rowIndex).getDonGia());
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
