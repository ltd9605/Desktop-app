package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.ProductDetail;
import com.mycompany.desktop_app.model.Product;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ProductDetailForm {
    private JFrame frame;
    private Product currentProduct;
    private ProductDetail currentProductDetail;

    // Các component
    private JTextField txtDetailId, txtProductId, txtImei, txtColor, txtStorage, txtRam, txtBattery, txtOs, txtWarranty, txtStatus;
    private JButton btnSave, btnCancel, btnEdit, btnDelete;

    public ProductDetailForm(Product p, ProductDetail detail) {
        this.currentProduct = p;
        this.currentProductDetail = detail;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Chi tiết sản phẩm");
        frame.setSize(500, 600);
        frame.setLayout(null);
        int labelX = 30, labelW = 100;
        int fieldX = 150, fieldW = 300, height = 30;
        int y = 30, gap = 40;

        JLabel lblDetailId = new JLabel("Mã chi tiết:");
        lblDetailId.setBounds(labelX, y, labelW, height);
        txtDetailId = new JTextField(String.valueOf(currentProductDetail.getProductDetailId()));
        txtDetailId.setBounds(fieldX, y, fieldW, height);
        txtDetailId.setEditable(false);

        y += gap;
        JLabel lblProductId = new JLabel("Mã sản phẩm:");
        lblProductId.setBounds(labelX, y, labelW, height);
        txtProductId = new JTextField(String.valueOf(currentProductDetail.getProductId()));
        txtProductId.setBounds(fieldX, y, fieldW, height);
        txtProductId.setEditable(false);

        y += gap;
        JLabel lblImei = new JLabel("IMEI:");
        lblImei.setBounds(labelX, y, labelW, height);
        txtImei = new JTextField(currentProductDetail.getImei());
        txtImei.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblColor = new JLabel("Màu sắc:");
        lblColor.setBounds(labelX, y, labelW, height);
        txtColor = new JTextField(currentProductDetail.getColor());
        txtColor.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblStorage = new JLabel("Bộ nhớ:");
        lblStorage.setBounds(labelX, y, labelW, height);
        txtStorage = new JTextField(currentProductDetail.getStorage());
        txtStorage.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblRam = new JLabel("RAM:");
        lblRam.setBounds(labelX, y, labelW, height);
        txtRam = new JTextField(currentProductDetail.getRam());
        txtRam.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblBattery = new JLabel("Pin:");
        lblBattery.setBounds(labelX, y, labelW, height);
        txtBattery = new JTextField(currentProductDetail.getBattery());
        txtBattery.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblOs = new JLabel("Hệ điều hành:");
        lblOs.setBounds(labelX, y, labelW, height);
        txtOs = new JTextField(currentProductDetail.getOs());
        txtOs.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblWarranty = new JLabel("Bảo hành (tháng):");
        lblWarranty.setBounds(labelX, y, labelW + 50, height);
        txtWarranty = new JTextField(String.valueOf(currentProductDetail.getWarranty()));
        txtWarranty.setBounds(fieldX, y, fieldW, height);

        y += gap;
        JLabel lblStatus = new JLabel("Trạng thái:");
        lblStatus.setBounds(labelX, y, labelW, height);
        txtStatus = new JTextField(String.valueOf(currentProductDetail.getStatus()));
        txtStatus.setBounds(fieldX, y, fieldW, height);

        y += gap + 10;
        btnSave = new JButton("Lưu");
        btnSave.setBounds(80, y, 100, 35);
        btnEdit = new JButton("Sửa");
        btnEdit.setBounds(200, y, 100, 35);
        btnDelete = new JButton("Xoá");
        btnDelete.setBounds(320, y, 100, 35);
        btnCancel = new JButton("Đóng");
        btnCancel.setBounds(200, y + 50, 100, 35);

        // Thêm các component
        frame.add(lblDetailId); frame.add(txtDetailId);
        frame.add(lblProductId); frame.add(txtProductId);
        frame.add(lblImei); frame.add(txtImei);
        frame.add(lblColor); frame.add(txtColor);
        frame.add(lblStorage); frame.add(txtStorage);
        frame.add(lblRam); frame.add(txtRam);
        frame.add(lblBattery); frame.add(txtBattery);
        frame.add(lblOs); frame.add(txtOs);
        frame.add(lblWarranty); frame.add(txtWarranty);
        frame.add(lblStatus); frame.add(txtStatus);
        frame.add(btnSave); frame.add(btnEdit); frame.add(btnDelete); frame.add(btnCancel);

        // Sự kiện nút
        btnCancel.addActionListener(e -> frame.dispose());
        btnSave.addActionListener(e -> saveProductDetail());
        btnEdit.addActionListener(e -> enableEditing(true));
        btnDelete.addActionListener(e -> deleteProductDetail());

        enableEditing(false);

        frame.setVisible(true);
    }

    private void enableEditing(boolean enable) {
        txtImei.setEditable(enable);
        txtColor.setEditable(enable);
        txtStorage.setEditable(enable);
        txtRam.setEditable(enable);
        txtBattery.setEditable(enable);
        txtOs.setEditable(enable);
        txtWarranty.setEditable(enable);
        txtStatus.setEditable(enable);
    }

    private void saveProductDetail() {
        // 
    }

    private void deleteProductDetail() {
        //
    }

}
