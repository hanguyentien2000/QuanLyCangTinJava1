/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Models.LoaiNhanVienDTO;
import Models.NhanVienDTO;
import SQLConnect.ConnectSQL;
import Store.StoreData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableNhanVien extends AbstractTableModel{
    private String name[]={"Mã NV","Họ tên","SDT", "Ngày sinh","Địa chỉ","Chức vụ", "Lương cơ bản", "Giới tính"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class, String.class, int.class, String.class, String.class, String.class, int.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ConnectSQL con = new ConnectSQL();
    ArrayList<NhanVienDTO> arrNV = new ArrayList<NhanVienDTO>();
    ArrayList<LoaiNhanVienDTO> arrLoaiNV = con.GetAllLoaiNV();
    //phương thức khởi tạo cho class có tham số truyền vào.
    public TableNhanVien()
    {
       this.arrNV = StoreData.dsNV;
    }

    @Override
    public int getRowCount()
    {
        return arrNV.size();
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
            case 0: return arrNV.get(rowIndex).getMaNV();
            case 1: return arrNV.get(rowIndex).getHoTen();
            case 2: return Integer.toString(arrNV.get(rowIndex).getsDT());
            case 3: return arrNV.get(rowIndex).getNgaySinh();
            case 4: return arrNV.get(rowIndex).getDiaChi();
            case 5: 
                String tenloainv = "";
                for(int i=0; i<arrLoaiNV.size(); i++){
                    if(arrLoaiNV.get(i).getMaLoaiNV()==arrNV.get(rowIndex).getMaLoaiNV())
                        tenloainv = arrLoaiNV.get(i).getTenLoaiNV();
                }
                return tenloainv;
//                return Integer.toString(arrNV.get(rowIndex).getMaLoaiNV());
            case 6: return Integer.toString(arrNV.get(rowIndex).getLuongCoBan());
            case 7: return arrNV.get(rowIndex).getGioitinh();
         
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
