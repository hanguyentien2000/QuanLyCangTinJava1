/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.HoaDonDTO;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableHoaDon extends AbstractTableModel{
    private String name[]={"Mã HD" ,"Mã bàn","Giờ đến","Trạng thái","Tổng tiền"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={int.class,int.class, String.class, String.class, int.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<HoaDonDTO> arrHD = new ArrayList<HoaDonDTO>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public TableHoaDon()
    {
       this.arrHD = StoreData.dsHD;
    }
    
    public TableHoaDon(ArrayList<HoaDonDTO> listHd)
    {
      this.arrHD = listHd;
    }
    
    
    @Override
    public int getRowCount()
    {
        return arrHD.size();
    }

    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    
    @Override
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return arrHD.get(rowIndex).getMaHoaDon();
            case 1: return arrHD.get(rowIndex).getMaBan();
            case 2: return arrHD.get(rowIndex).getGioDen();
            case 3: return arrHD.get(rowIndex).getTrangThai() ? "Đã thanh toán" : "Chưa thanh toán";
            case 4: return arrHD.get(rowIndex).getTongTien();
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
