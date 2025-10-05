package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.CTPhieuNhap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CTPhieuNhapForm {
    private JFrame frame;
    private JTextField txtId, txtPhieuNhapId, txtProductId, txtQuantity, txtPrice;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<CTPhieuNhap> listCT = new ArrayList<>();

    public CTPhieuNhapForm() {
        frame = new JFrame("Chi Tiết Phiếu Nhập");
        frame.setLayout(null);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel("Danh sách chi tiết phiếu nhập:");
        title.setBounds(20,10,300,20);
        frame.add(title);

        JPanel inputPanel = new JPanel(null);
        inputPanel.setBounds(20,40,740,150);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));

        JLabel lblId = new JLabel("Mã CTPN:"); txtId = new JTextField(); txtId.setBounds(100,20,150,20); lblId.setBounds(10,20,80,20);
        JLabel lblPN = new JLabel("Mã PN:"); txtPhieuNhapId = new JTextField(); txtPhieuNhapId.setBounds(100,50,150,20); lblPN.setBounds(10,50,80,20);
        JLabel lblSP = new JLabel("Mã SP:"); txtProductId = new JTextField(); txtProductId.setBounds(400,20,150,20); lblSP.setBounds(300,20,80,20);
        JLabel lblQuantity = new JLabel("Số lượng:"); txtQuantity = new JTextField(); txtQuantity.setBounds(400,50,150,20); lblQuantity.setBounds(300,50,80,20);
        JLabel lblPrice = new JLabel("Giá:"); txtPrice = new JTextField(); txtPrice.setBounds(600,20,120,20); lblPrice.setBounds(550,20,50,20);

        inputPanel.add(lblId); inputPanel.add(txtId);
        inputPanel.add(lblPN); inputPanel.add(txtPhieuNhapId);
        inputPanel.add(lblSP); inputPanel.add(txtProductId);
        inputPanel.add(lblQuantity); inputPanel.add(txtQuantity);
        inputPanel.add(lblPrice); inputPanel.add(txtPrice);

        frame.add(inputPanel);

        JButton btnAdd = new JButton("Thêm"); btnAdd.setBounds(20,200,80,25);
        JButton btnEdit = new JButton("Sửa"); btnEdit.setBounds(120,200,80,25);
        JButton btnDelete = new JButton("Xóa"); btnDelete.setBounds(220,200,80,25);
        JButton btnClear = new JButton("Làm mới"); btnClear.setBounds(320,200,100,25);

        frame.add(btnAdd); frame.add(btnEdit); frame.add(btnDelete); frame.add(btnClear);

        JTextField searchTxt = new JTextField(); searchTxt.setBounds(500,200,180,25);
        JButton searchBtn = new JButton("Tìm kiếm"); searchBtn.setBounds(690,200,80,25);
        frame.add(searchTxt); frame.add(searchBtn);

        String[] columns = {"Mã CTPN","Mã PN","Mã SP","Số lượng","Giá"};
        model = new DefaultTableModel(columns,0);
        table = new JTable(model);
        JScrollPane sc = new JScrollPane(table); sc.setBounds(20,240,740,200);
        frame.add(sc);

        // Event
        btnAdd.addActionListener(e -> addCT());
        btnEdit.addActionListener(e -> editCT());
        btnDelete.addActionListener(e -> deleteCT());
        btnClear.addActionListener(e -> clearForm());
        searchBtn.addActionListener(e -> searchCT(searchTxt.getText()));

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                int row = table.getSelectedRow();
                if(row>=0){
                    CTPhieuNhap ct = listCT.get(row);
                    txtId.setText(String.valueOf(ct.getCtPhieuNhapId()));
                    txtPhieuNhapId.setText(String.valueOf(ct.getPhieuNhapId()));
                    txtProductId.setText(String.valueOf(ct.getProductId()));
                    txtQuantity.setText(String.valueOf(ct.getQuantity()));
                    txtPrice.setText(String.valueOf(ct.getPrice()));
                }
            }
        });

        frame.setVisible(true);
    }

    private void addCT(){
        try{
            CTPhieuNhap ct = new CTPhieuNhap(
                    Integer.parseInt(txtId.getText()),
                    Integer.parseInt(txtPhieuNhapId.getText()),
                    Integer.parseInt(txtProductId.getText()),
                    Integer.parseInt(txtQuantity.getText()),
                    Float.parseFloat(txtPrice.getText())
            );
            listCT.add(ct);
            model.addRow(new Object[]{ct.getCtPhieuNhapId(),ct.getPhieuNhapId(),ct.getProductId(),ct.getQuantity(),ct.getPrice()});
            clearForm();
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Dữ liệu không hợp lệ!");
        }
    }

    private void editCT(){
        int row = table.getSelectedRow();
        if(row>=0){
            try{
                CTPhieuNhap ct = listCT.get(row);
                ct.setPhieuNhapId(Integer.parseInt(txtPhieuNhapId.getText()));
                ct.setProductId(Integer.parseInt(txtProductId.getText()));
                ct.setQuantity(Integer.parseInt(txtQuantity.getText()));
                ct.setPrice(Float.parseFloat(txtPrice.getText()));

                model.setValueAt(ct.getPhieuNhapId(),row,1);
                model.setValueAt(ct.getProductId(),row,2);
                model.setValueAt(ct.getQuantity(),row,3);
                model.setValueAt(ct.getPrice(),row,4);
                clearForm();
            }catch(Exception e){ JOptionPane.showMessageDialog(frame,"Dữ liệu không hợp lệ!"); }
        }else JOptionPane.showMessageDialog(frame,"Chọn chi tiết để sửa!");
    }

    private void deleteCT(){
        int row = table.getSelectedRow();
        if(row>=0){
            listCT.remove(row);
            model.removeRow(row);
            clearForm();
        }else JOptionPane.showMessageDialog(frame,"Chọn chi tiết để xóa!");
    }

    private void clearForm(){
        txtId.setText(""); txtPhieuNhapId.setText(""); txtProductId.setText("");
        txtQuantity.setText(""); txtPrice.setText("");
    }

    private void searchCT(String keyword){
        DefaultTableModel searchModel = new DefaultTableModel(new String[]{"Mã CTPN","Mã PN","Mã SP","Số lượng","Giá"},0);
        for(CTPhieuNhap ct : listCT){
            if(String.valueOf(ct.getCtPhieuNhapId()).contains(keyword) || String.valueOf(ct.getProductId()).contains(keyword)){
                searchModel.addRow(new Object[]{ct.getCtPhieuNhapId(),ct.getPhieuNhapId(),ct.getProductId(),ct.getQuantity(),ct.getPrice()});
            }
        }
        table.setModel(searchModel);
    }
}
