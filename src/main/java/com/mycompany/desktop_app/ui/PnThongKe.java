
package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.bus.KhachHangBUS; 
import com.mycompany.desktop_app.bus.NhanVienBUS;
import com.mycompany.desktop_app.bus.SanPhamBUS;
import com.mycompany.desktop_app.model.SanPham; 
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Panel Thống Kê
 * @author duysenpai234
 */
public class PnThongKe extends JPanel {

    
    private SanPhamBUS sanPhamBUS;
    private KhachHangBUS khachHangBUS;
    private NhanVienBUS nhanVienBUS;
    
    private JLabel productCountLabel, customerCountLabel, employeeCountLabel;
    private JTable lowStockTable;
    private DefaultTableModel tableModel;

   
    public PnThongKe(SanPhamBUS spBUS, KhachHangBUS khBUS, NhanVienBUS nvBUS) {
        this.sanPhamBUS = spBUS;
        this.khachHangBUS = khBUS;
        this.nhanVienBUS = nvBUS;

        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        initComponents();
        loadData();
    }

    private void initComponents() {
        // ---- MAIN TITLE ----
        JLabel mainTitle = new JLabel("Thống Kê Tổng Quan");
        mainTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(mainTitle, BorderLayout.NORTH);

        // ---- CENTER PANEL ----
        JPanel centerPanel = new JPanel(new BorderLayout(10, 20));

        // ---- Summary Panel (Thống kê chung) ----
        JPanel summaryPanel = new JPanel(new GridLayout(1, 3, 20, 0)); // GridLayout để các mục đều nhau
        summaryPanel.setBorder(new TitledBorder("Thống kê chung"));
        
        productCountLabel = new JLabel("Tổng sản phẩm: 0");
        customerCountLabel = new JLabel("Tổng khách hàng: 0");
        employeeCountLabel = new JLabel("Tổng nhân viên: 0");
        
        // Căn giữa cho đẹp
        productCountLabel.setHorizontalAlignment(JLabel.CENTER);
        customerCountLabel.setHorizontalAlignment(JLabel.CENTER);
        employeeCountLabel.setHorizontalAlignment(JLabel.CENTER);
        
        summaryPanel.add(productCountLabel);
        summaryPanel.add(customerCountLabel);
        summaryPanel.add(employeeCountLabel);
        
        centerPanel.add(summaryPanel, BorderLayout.NORTH);

        // ---- Low Stock Panel (Sản phẩm sắp hết hàng) ----
        JPanel lowStockPanel = new JPanel(new BorderLayout());
        lowStockPanel.setBorder(new TitledBorder("Sản phẩm sắp hết hàng (Số lượng < 20)"));

        String[] columnNames = {"Mã SP", "Tên sản phẩm", "Số lượng còn lại"};
        tableModel = new DefaultTableModel(columnNames, 0);
        lowStockTable = new JTable(tableModel);

        lowStockPanel.add(new JScrollPane(lowStockTable), BorderLayout.CENTER);
        centerPanel.add(lowStockPanel, BorderLayout.CENTER);
        
        add(centerPanel, BorderLayout.CENTER);
    }
    
  
    public void loadData() {
        updateSummary();
        loadLowStockTable();
    }
    
    private void updateSummary() {
        
        int productCount = sanPhamBUS.getSoLuongSanPham(); 
        int customerCount = khachHangBUS.getSoLuongKhachHang();
        int employeeCount = nhanVienBUS.getSoLuongNhanVien();

        productCountLabel.setText("Tổng sản phẩm: " + productCount);
        customerCountLabel.setText("Tổng khách hàng: " + customerCount);
        employeeCountLabel.setText("Tổng nhân viên: " + employeeCount);
    }

    private void loadLowStockTable() {
        tableModel.setRowCount(0); 
        
        
        ArrayList<SanPham> lowStockList = sanPhamBUS.getSanPhamSapHetHang(20); 

        for (SanPham sp : lowStockList) {
            Object[] row = {
                sp.getMaSanPham(), 
                sp.getTenSanPham(),
                sp.getSoLuong()
            };
            tableModel.addRow(row);
        }
    }
}