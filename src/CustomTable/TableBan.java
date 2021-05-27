/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.BanDTO;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableBan extends AbstractTableModel{
    private String name[]={"Mã bàn","Tên bàn","Trạng thái"};
   
    private Class classes[]={int.class, String.class, String.class};
    
    ArrayList<BanDTO> arrBan = new ArrayList<BanDTO>();

    public TableBan()
    {
       this.arrBan = StoreData.dsBan;
    }

    public TableBan(ArrayList<BanDTO> arrBan) {
        this.arrBan = arrBan;
    }
    

    @Override
    public int getRowCount()
    {
        return arrBan.size();
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
            case 0: return Integer.toString(arrBan.get(rowIndex).GetMaBan());
            case 1: return arrBan.get(rowIndex).GetTenBan();
            case 2: return arrBan.get(rowIndex).GetTrangThai();
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
