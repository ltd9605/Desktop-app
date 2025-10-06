
package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.NhanVien; 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Panel quản lý Nhân Viên
 * @author duysenpai234
 */
public class PnNhanVien extends JPanel { 

    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JButton addBtn, editBtn, deleteBtn, searchBtn;
    private JTextField searchTxt;

   
    public ArrayList<NhanVien> createSampleData() {
        ArrayList<NhanVien> employeeList = new ArrayList<>();
        employeeList.add(new NhanVien(1, "Lê Trần Duy", "0905111222", "72 Nguyễn Huệ, Quận 1, TP.HCM", "duyadmin", "admin@123", "Quản lý"));
        employeeList.add(new NhanVien(2, "Bùi Văn Kiên", "0987123456", "111 Đường A, Quận 1, TP.HCM", "kienbv", "pass123", "Nhân viên"));
        employeeList.add(new NhanVien(3, "Ngô Thị My", "0909456789", "222 Đường B, Quận 3, TP.HCM", "mynt", "pass123", "Nhân viên"));
        employeeList.add(new NhanVien(4, "Đặng Văn Long", "0933789123", "333 Đường C, Quận 5, TP.HCM", "longdv", "pass123", "Nhân viên"));
        employeeList.add(new NhanVien(5, "Trần Thúy Vy", "0918123789", "444 Đường D, Quận 7, TP.HCM", "vitt", "pass123", "Nhân viên"));
        return employeeList;
    }

    public PnNhanVien() {
       
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        
        initComponents();
        loadTableData();
    }

    private void initComponents() {
       
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
        titleLabel.setFont(titleLabel.getFont().deriveFont(18.0f));
        topPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchTxt = new JTextField("Nhập tên nhân viên");
        searchTxt.setPreferredSize(new Dimension(200, 25));
        searchBtn = new JButton("Tìm kiếm");
        searchPanel.add(searchTxt);
        searchPanel.add(searchBtn);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        
        addBtn = new JButton("Thêm mới");
        topPanel.add(addBtn, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        
        String[] columnNames = {"Mã NV", "Họ Tên", "Số điện thoại", "Địa chỉ", "Tên đăng nhập", "Vai trò"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        editBtn = new JButton("Sửa");
        deleteBtn = new JButton("Xóa");
        bottomPanel.add(editBtn);
        bottomPanel.add(deleteBtn);

        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void loadTableData() {
        tableModel.setRowCount(0);
        
        ArrayList<NhanVien> employeeList = createSampleData();
        
        for (NhanVien nv : employeeList) {
            Object[] row = {
                nv.getMaNhanVien(),
                nv.getHoTen(),
                nv.getSoDienThoai(),
                nv.getDiaChi(),
                nv.getTenDangNhap(),
                nv.getVaiTro()
            };
            tableModel.addRow(row);
        }
    }
}