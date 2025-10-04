/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desktop_app.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.mycompany.desktop_app.model.Product;
import static java.awt.Color.GRAY;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ltd96
 */
public class ProductForm {
    JFrame frame ;
    // Khởi tạo dữ liệu mẫu
    public ArrayList InitArrayListExample() {
    ArrayList<Product> productList = new ArrayList<>();

    // Iphone
    productList.add(new Product(1, "Iphone 15 Pro", 2, 1, 50,
            "https://example.com/iphone15pro.jpg", 29999.0f, "Hàng mới 100%", "Còn hàng"));
    productList.add(new Product(2, "Iphone 14", 2, 1, 40,
            "https://example.com/iphone14.jpg", 22999.0f, "Giá tốt, hàng like new", "Còn hàng"));
    productList.add(new Product(3, "Iphone 13 Mini", 2, 1, 25,
            "https://example.com/iphone13mini.jpg", 15999.0f, "Nhỏ gọn, pin ổn", "Còn hàng"));

    // Samsung
    productList.add(new Product(4, "Samsung Galaxy S24", 3, 2, 30,
            "https://example.com/s24.jpg", 25999.0f, "Flagship mới nhất", "Còn hàng"));
    productList.add(new Product(5, "Samsung Galaxy Z Flip 5", 3, 2, 15,
            "https://example.com/zflip5.jpg", 28999.0f, "Gập độc đáo", "Còn hàng"));
    productList.add(new Product(6, "Samsung A54", 3, 2, 60,
            "https://example.com/a54.jpg", 8999.0f, "Tầm trung giá tốt", "Còn hàng"));

    // Oppo
    productList.add(new Product(7, "Oppo Reno 11", 4, 3, 20,
            "https://example.com/opporeno11.jpg", 12999.0f, "Thiết kế đẹp, giá tốt", "Còn hàng"));
    productList.add(new Product(8, "Oppo Find X6", 4, 3, 12,
            "https://example.com/findx6.jpg", 18999.0f, "Camera siêu xịn", "Còn hàng"));

    // Xiaomi
    productList.add(new Product(9, "Xiaomi 13 Pro", 5, 4, 22,
            "https://example.com/xiaomi13pro.jpg", 16999.0f, "Hợp tác Leica, camera xịn", "Còn hàng"));
    productList.add(new Product(10, "Xiaomi Redmi Note 12", 5, 4, 70,
            "https://example.com/redmi12.jpg", 5999.0f, "Giá rẻ, pin trâu", "Còn hàng"));

    // iPad
    productList.add(new Product(11, "iPad Pro M2", 1, 1, 18,
            "https://example.com/ipadprom2.jpg", 31999.0f, "Mạnh mẽ, dành cho công việc", "Còn hàng"));
    productList.add(new Product(12, "iPad Air 5", 1, 1, 25,
            "https://example.com/ipadair5.jpg", 18999.0f, "Nhẹ, tiện dụng", "Còn hàng"));

    return productList;
}

    public ProductForm(){
        frame = new JFrame("Product");
        frame.setLayout(null);
        frame.setSize(600,400);
        JLabel title = new JLabel("Danh sách sản phẩm :");
        title.setBounds(20,20,200,20);
        frame.add(title);
        JButton addProductBtn = new JButton("Thêm sản phẩm");
        addProductBtn.setBounds(480,20,100,20);
        JPanel containerPn = new JPanel();
        containerPn.setBounds(20,60,540,240);
        containerPn.setLayout(null);
        containerPn.setBackground(GRAY);
        JTextField searchTxt = new JTextField("Nhập tên sản phẩm");
        searchTxt.setBounds(10,10,150,20);
        JButton searchBtn = new JButton("Tìm kiếm");
        searchBtn.setBounds(185,10,100,20);
        containerPn.add(searchTxt);
        containerPn.add(searchBtn);
        String[] categories = {"Tất cả" , "Ipad","Iphone","SamSung","Oppo","Xiaomi"};
        JComboBox categoryCbx = new JComboBox(categories);
        categoryCbx.setBounds(400,10,100,20);
        containerPn.add(categoryCbx);
        ArrayList<Product> pList = InitArrayListExample();
        String[] columnNames = {"ID", "Tên sản phẩm", "CategoryId", "SupplierId","Số lượng", "Ảnh", "Giá", "Mô tả", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(Product p : pList){
            Object[] row = {
                 p.getProductId(),
                    p.getProductName(),
                    p.getCategoryId(),
                    p.getSupplierId(),
                    p.getQuantity(),
                    p.getImgUrl(),
                    p.getPrice(),
                    p.getDescription(),
                    p.getStatus()
            };
            model.addRow(row);
        };
        JTable table = new JTable(model);
        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(0,40,540, 200);
        containerPn.add(sc);
        frame.add(containerPn);
        JButton editBtn = new JButton("Sửa");
        editBtn.setBounds(480,320,100,20);
        frame.add(editBtn);
        frame.add(addProductBtn);
        frame.setVisible(true);
    }
}
