package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.PhieuNhap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class PhieuNhapForm {
    private JFrame frame;
    private JTextField txtId, txtSupplierId, txtTongTien, txtStatus;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<PhieuNhap> listPN = new ArrayList<>();

    public PhieuNhapForm() {
        frame = new JFrame("Quản lý Phiếu Nhập");
        frame.setLayout(null);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel("Danh sách Phiếu Nhập:");
        title.setBounds(20,10,200,20);
        frame.add(title);

        // --- Form nhập liệu ---
        JPanel inputPanel = new JPanel(null);
        inputPanel.setBounds(20,40,740,150);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin Phiếu Nhập"));

        JLabel lblId = new JLabel("Mã PN:");
        lblId.setBounds(10,20,80,20);
        txtId = new JTextField();
        txtId.setBounds(100,20,150,20);

        JLabel lblSupplier = new JLabel("Mã NCC:");
        lblSupplier.setBounds(10,50,80,20);
        txtSupplierId = new JTextField();
        txtSupplierId.setBounds(100,50,150,20);

        JLabel lblTongTien = new JLabel("Tổng tiền:");
        lblTongTien.setBounds(300,20,80,20);
        txtTongTien = new JTextField();
        txtTongTien.setBounds(400,20,150,20);

        JLabel lblStatus = new JLabel("Trạng thái:");
        lblStatus.setBounds(300,50,80,20);
        txtStatus = new JTextField();
        txtStatus.setBounds(400,50,150,20);

        inputPanel.add(lblId); inputPanel.add(txtId);
        inputPanel.add(lblSupplier); inputPanel.add(txtSupplierId);
        inputPanel.add(lblTongTien); inputPanel.add(txtTongTien);
        inputPanel.add(lblStatus); inputPanel.add(txtStatus);

        frame.add(inputPanel);

        // --- Nút ---
        JButton btnAdd = new JButton("Thêm");
        btnAdd.setBounds(20,200,80,25);
        JButton btnEdit = new JButton("Sửa");
        btnEdit.setBounds(120,200,80,25);
        JButton btnDelete = new JButton("Xóa");
        btnDelete.setBounds(220,200,80,25);
        JButton btnClear = new JButton("Làm mới");
        btnClear.setBounds(320,200,100,25);

        frame.add(btnAdd); frame.add(btnEdit); frame.add(btnDelete); frame.add(btnClear);

        // --- Tìm kiếm ---
        JTextField searchTxt = new JTextField();
        searchTxt.setBounds(500,200,180,25);
        JButton searchBtn = new JButton("Tìm kiếm");
        searchBtn.setBounds(690,200,80,25);
        frame.add(searchTxt); frame.add(searchBtn);

        // --- Table ---
        String[] columnNames = {"Mã PN","Mã NCC","Ngày nhập","Tổng tiền","Trạng thái"};
        model = new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(20,240,740,200);
        frame.add(sc);

        // --- Event ---
        btnAdd.addActionListener(e -> addPN());
        btnEdit.addActionListener(e -> editPN());
        btnDelete.addActionListener(e -> deletePN());
        btnClear.addActionListener(e -> clearForm());
        searchBtn.addActionListener(e -> searchPN(searchTxt.getText()));

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = table.getSelectedRow();
                if(row>=0){
                    PhieuNhap pn = listPN.get(row);
                    txtId.setText(String.valueOf(pn.getPhieuNhapId()));
                    txtSupplierId.setText(String.valueOf(pn.getSupplierId()));
                    txtTongTien.setText(String.valueOf(pn.getTongTien()));
                    txtStatus.setText(pn.getStatus());
                }
            }
        });

        frame.setVisible(true);
    }

    private void addPN(){
        try{
            PhieuNhap pn = new PhieuNhap(
                    Integer.parseInt(txtId.getText()),
                    Integer.parseInt(txtSupplierId.getText()),
                    new Date(),
                    Float.parseFloat(txtTongTien.getText()),
                    txtStatus.getText()
            );
            listPN.add(pn);
            model.addRow(new Object[]{pn.getPhieuNhapId(), pn.getSupplierId(), pn.getNgayNhap(), pn.getTongTien(), pn.getStatus()});
            clearForm();
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Dữ liệu không hợp lệ!");
        }
    }

    private void editPN(){
        int row = table.getSelectedRow();
        if(row>=0){
            try{
                PhieuNhap pn = listPN.get(row);
                pn.setSupplierId(Integer.parseInt(txtSupplierId.getText()));
                pn.setTongTien(Float.parseFloat(txtTongTien.getText()));
                pn.setStatus(txtStatus.getText());
                model.setValueAt(pn.getSupplierId(), row,1);
                model.setValueAt(pn.getTongTien(), row,3);
                model.setValueAt(pn.getStatus(), row,4);
                clearForm();
            }catch(Exception e){
                JOptionPane.showMessageDialog(frame,"Dữ liệu không hợp lệ!");
            }
        }else JOptionPane.showMessageDialog(frame,"Chọn phiếu để sửa!");
    }

    private void deletePN(){
        int row = table.getSelectedRow();
        if(row>=0){
            listPN.remove(row);
            model.removeRow(row);
            clearForm();
        }else JOptionPane.showMessageDialog(frame,"Chọn phiếu để xóa!");
    }

    private void clearForm(){
        txtId.setText(""); txtSupplierId.setText(""); txtTongTien.setText(""); txtStatus.setText("");
    }

    private void searchPN(String keyword){
        DefaultTableModel searchModel = new DefaultTableModel(new String[]{"Mã PN","Mã NCC","Ngày nhập","Tổng tiền","Trạng thái"},0);
        for(PhieuNhap pn : listPN){
            if(String.valueOf(pn.getPhieuNhapId()).contains(keyword) || String.valueOf(pn.getSupplierId()).contains(keyword)){
                searchModel.addRow(new Object[]{pn.getPhieuNhapId(),pn.getSupplierId(),pn.getNgayNhap(),pn.getTongTien(),pn.getStatus()});
            }
        }
        table.setModel(searchModel);
    }
}
