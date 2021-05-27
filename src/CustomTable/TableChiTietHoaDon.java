/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.HoaDonDTO;
import Models.ChiTietHoaDonDTO;
import Models.MonAnDTO;
import SQLConnect.ConnectSQL;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableChiTietHoaDon extends AbstractTableModel{
    private String name[]={"Tên món", "Số lượng", "Đơn giá", "Ghi chú"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class, int.class, int.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    int maHD;
    ConnectSQL con = new ConnectSQL();
    ArrayList<ChiTietHoaDonDTO> arrCTHD = new ArrayList<ChiTietHoaDonDTO>();
    ArrayList<MonAnDTO> arrMon = con.GetAllMon(null);

    //phương thức khởi tạo cho class có tham số truyền vào.

    public TableChiTietHoaDon() {
    }

    public TableChiTietHoaDon(ArrayList<ChiTietHoaDonDTO> listHd)
    {
      this.arrCTHD = listHd;
    }
    
    
    @Override
    public int getRowCount()
    {
        return arrCTHD.size();
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
            case 0: {
                String tenmon = "";
                for(int i=0; i<arrMon.size(); i++){
                    if(arrMon.get(i).getMaMon()==arrCTHD.get(rowIndex).getMaMon())
                        tenmon = arrMon.get(i).getTenMon();
                }
                return tenmon;
            }
            case 1: return Integer.toString(arrCTHD.get(rowIndex).getSoLuong());
            case 2: {
                int dongia = 0;
                for(int i=0; i<arrMon.size(); i++){
                    if(arrMon.get(i).getMaMon()==arrCTHD.get(rowIndex).getMaMon())
                        dongia = arrMon.get(i).getDonGia();
                }
                return dongia;
            }
            case 3: return arrCTHD.get(rowIndex).getGhiChu();
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
