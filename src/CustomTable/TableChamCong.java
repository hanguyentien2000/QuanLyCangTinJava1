/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.ChamCongDTO;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class TableChamCong extends AbstractTableModel{
    private String name[]={"Mã NV", "Ngày"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<ChamCongDTO> arrCC = new ArrayList<ChamCongDTO>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public TableChamCong()
    {
       this.arrCC = StoreData.dsCC;
    }
    //đay la customtable model á. Nó có nhận ko ? nhận mà

    public TableChamCong(ArrayList<ChamCongDTO> listCC) {
        this.arrCC = listCC;
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
            case 0: return arrCC.get(rowIndex).getMaNV().toString();
            case 1: return arrCC.get(rowIndex).getNgay().toString();
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
