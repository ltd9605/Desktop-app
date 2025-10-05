package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.Product;
import java.awt.Font;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duysenpai234
 */
public class StatisticsForm {
    JFrame frame;

    public StatisticsForm() {
        frame = new JFrame("Bảng Thống Kê");
        frame.setLayout(null);
        frame.setSize(600, 450);

        JLabel title = new JLabel("Thống kê tổng quan");
        title.setBounds(20, 10, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(title);

        // --- Panel thống kê chung ---
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(20, 50, 560, 80);
        summaryPanel.setBorder(new TitledBorder("Thống kê chung"));
        frame.add(summaryPanel);

        // Lấy dữ liệu từ các form khác (để tính toán)
        int productCount = new ProductForm().InitArrayListExample().size();
        int customerCount = new CustomerForm().InitCustomerList().size();
        int employeeCount = new EmployeeForm().InitEmployeeList().size();
        
        JLabel productLabel = new JLabel("Tổng số sản phẩm: " + productCount);
        productLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        productLabel.setBounds(20, 30, 200, 20);
        summaryPanel.add(productLabel);

        JLabel customerLabel = new JLabel("Tổng số khách hàng: " + customerCount);
        customerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        customerLabel.setBounds(220, 30, 200, 20);
        summaryPanel.add(customerLabel);

        JLabel employeeLabel = new JLabel("Tổng số nhân viên: " + employeeCount);
        employeeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        employeeLabel.setBounds(420, 30, 200, 20);
        summaryPanel.add(employeeLabel);
        
        // --- Panel thống kê sản phẩm sắp hết hàng ---
        JPanel lowStockPanel = new JPanel();
        lowStockPanel.setLayout(null);
        lowStockPanel.setBounds(20, 150, 560, 250);
        lowStockPanel.setBorder(new TitledBorder("Sản phẩm sắp hết hàng (Số lượng < 20)"));
        frame.add(lowStockPanel);
        
        // Lọc sản phẩm có số lượng thấp
        ArrayList<Product> allProducts = new ProductForm().InitArrayListExample();
        ArrayList<Product> lowStockProducts = (ArrayList<Product>) allProducts.stream()
                .filter(p -> p.getQuantity() < 20)
                .collect(Collectors.toList());

        String[] columnNames = {"ID", "Tên sản phẩm", "Số lượng còn lại"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Product p : lowStockProducts) {
            Object[] row = {
                p.getProductId(),
                p.getProductName(),
                p.getQuantity()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(10, 20, 540, 220);
        lowStockPanel.add(sc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}