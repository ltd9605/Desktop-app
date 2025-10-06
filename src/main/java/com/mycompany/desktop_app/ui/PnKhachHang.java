
package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.KhachHang;
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
 * Panel quản lý Khách Hàng
 * @author duysenpai234
 */
public class PnKhachHang extends JPanel { 

    private JTable customerTable;
    private DefaultTableModel tableModel;
    private JButton addBtn, editBtn, deleteBtn, searchBtn;
    private JTextField searchTxt;

    public ArrayList<KhachHang> createSampleData() {
        ArrayList<KhachHang> customerList = new ArrayList<>();
        customerList.add(new KhachHang(1, "Nguyễn Văn An", "0912345678", "an.nv@email.com", "123 Đường ABC, Quận 1, TP.HCM"));
        customerList.add(new KhachHang(2, "Trần Thị Bình", "0987654321", "binh.tt@email.com", "456 Đường XYZ, Quận 3, TP.HCM"));
        customerList.add(new KhachHang(3, "Lê Văn Cường", "0905123123", "cuong.lv@email.com", "789 Đường DEF, Quận Gò Vấp, TP.HCM"));
        customerList.add(new KhachHang(4, "Phạm Thị Dung", "0334567890", "dung.pt@email.com", "101 Đường GHI, TP. Thủ Đức, TP.HCM"));
        customerList.add(new KhachHang(5, "Hoàng Văn Em", "0778889990", "em.hv@email.com", "222 Đường JKL, Quận 7, TP.HCM"));
        customerList.add(new KhachHang(6, "Võ Thị Gái", "0944112233", "gai.vt@email.com", "333 Đường MNO, Quận Bình Thạnh, TP.HCM"));
        customerList.add(new KhachHang(7, "Đinh Quang Hùng", "0888999777", "hung.dq@email.com", "444 Đường PQR, Quận 10, TP.HCM"));
        return customerList;
    }

    public PnKhachHang() {
        
        setLayout(new BorderLayout(10, 10)); 
        setBorder(new EmptyBorder(10, 10, 10, 10)); 
        
        initComponents();
        loadTableData();
    }

    private void initComponents() {
        // ---- TOP PANEL ----
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));

        // Title
        JLabel titleLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
        titleLabel.setFont(titleLabel.getFont().deriveFont(18.0f)); 
        topPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        searchTxt = new JTextField("Nhập tên khách hàng");
        searchTxt.setPreferredSize(new Dimension(200, 25));
        searchBtn = new JButton("Tìm kiếm");
        searchPanel.add(searchTxt);
        searchPanel.add(searchBtn);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        
        addBtn = new JButton("Thêm mới");
        topPanel.add(addBtn, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH); 

        // ---- CENTER PANEL (TABLE) ----
        String[] columnNames = {"Mã KH", "Họ Tên", "Số điện thoại", "Email", "Địa chỉ"};
        tableModel = new DefaultTableModel(columnNames, 0);
        customerTable = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(customerTable);
        add(scrollPane, BorderLayout.CENTER); 

        // ---- BOTTOM PANEL ----
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        editBtn = new JButton("Sửa");
        deleteBtn = new JButton("Xóa");
        bottomPanel.add(editBtn);
        bottomPanel.add(deleteBtn);

        add(bottomPanel, BorderLayout.SOUTH); 
    }
    
    // Phương thức để tải dữ liệu vào bảng
    private void loadTableData() {
        
        tableModel.setRowCount(0);
        
     
        ArrayList<KhachHang> customerList = createSampleData();
        
        
        for (KhachHang kh : customerList) {
            Object[] row = {
                kh.getMaKhachHang(),
                kh.getHoTen(),
                kh.getSoDienThoai(),
                kh.getEmail(),
                kh.getDiaChi()
            };
            tableModel.addRow(row);
        }
    }
}