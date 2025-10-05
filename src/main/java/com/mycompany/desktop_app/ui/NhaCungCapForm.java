package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.NhaCungCap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class NhaCungCapForm {
    private JFrame frame;
    private JTextField txtId, txtName, txtAddress, txtPhone;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<NhaCungCap> listNCC = new ArrayList<>();

    public NhaCungCapForm() {
        frame = new JFrame("Quản lý Nhà Cung Cấp");
        frame.setLayout(null);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel("Danh sách Nhà Cung Cấp:");
        title.setBounds(20,10,300,20);
        frame.add(title);

        JPanel inputPanel = new JPanel(null);
        inputPanel.setBounds(20,40,740,150);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin NCC"));

        JLabel lblId = new JLabel("Mã NCC:"); txtId = new JTextField(); txtId.setBounds(100,20,150,20); lblId.setBounds(10,20,80,20);
        JLabel lblName = new JLabel("Tên NCC:"); txtName = new JTextField(); txtName.setBounds(100,50,150,20); lblName.setBounds(10,50,80,20);
        JLabel lblAddress = new JLabel("Địa chỉ:"); txtAddress = new JTextField(); txtAddress.setBounds(400,20,200,20); lblAddress.setBounds(300,20,80,20);
        JLabel lblPhone = new JLabel("SĐT:"); txtPhone = new JTextField(); txtPhone.setBounds(400,50,200,20); lblPhone.setBounds(300,50,80,20);

        inputPanel.add(lblId); inputPanel.add(txtId);
        inputPanel.add(lblName); inputPanel.add(txtName);
        inputPanel.add(lblAddress); inputPanel.add(txtAddress);
        inputPanel.add(lblPhone); inputPanel.add(txtPhone);
        frame.add(inputPanel);

        JButton btnAdd = new JButton("Thêm"); btnAdd.setBounds(20,200,80,25);
        JButton btnEdit = new JButton("Sửa"); btnEdit.setBounds(120,200,80,25);
        JButton btnDelete = new JButton("Xóa"); btnDelete.setBounds(220,200,80,25);
        JButton btnClear = new JButton("Làm mới"); btnClear.setBounds(320,200,100,25);

        frame.add(btnAdd); frame.add(btnEdit); frame.add(btnDelete); frame.add(btnClear);

        JTextField searchTxt = new JTextField(); searchTxt.setBounds(500,200,180,25);
        JButton searchBtn = new JButton("Tìm kiếm"); searchBtn.setBounds(690,200,80,25);
        frame.add(searchTxt); frame.add(searchBtn);

        String[] columns = {"Mã NCC","Tên NCC","Địa chỉ","SĐT"};
        model = new DefaultTableModel(columns,0);
        table = new JTable(model);
        JScrollPane sc = new JScrollPane(table); sc.setBounds(20,240,740,200);
        frame.add(sc);

        btnAdd.addActionListener(e -> addNCC());
        btnEdit.addActionListener(e -> editNCC());
        btnDelete.addActionListener(e -> deleteNCC());
        btnClear.addActionListener(e -> clearForm());
        searchBtn.addActionListener(e -> searchNCC(searchTxt.getText()));

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                int row = table.getSelectedRow();
                if(row>=0){
                    NhaCungCap ncc = listNCC.get(row);
                    txtId.setText(String.valueOf(ncc.getSupplierId()));
                    txtName.setText(ncc.getSupplierName());
                    txtAddress.setText(ncc.getAddress());
                    txtPhone.setText(ncc.getPhone());
                }
            }
        });

        frame.setVisible(true);
    }

    private void addNCC(){
        try{
            NhaCungCap ncc = new NhaCungCap(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtPhone.getText()
            );
            listNCC.add(ncc);
            model.addRow(new Object[]{ncc.getSupplierId(),ncc.getSupplierName(),ncc.getAddress(),ncc.getPhone()});
            clearForm();
        }catch(Exception e){ JOptionPane.showMessageDialog(frame,"Dữ liệu không hợp lệ!");}
    }

    private void editNCC(){
        int row = table.getSelectedRow();
        if(row>=0){
            try{
                NhaCungCap ncc = listNCC.get(row);
                ncc.setSupplierName(txtName.getText());
                ncc.setAddress(txtAddress.getText());
                ncc.setPhone(txtPhone.getText());
                model.setValueAt(ncc.getSupplierName(),row,1);
                model.setValueAt(ncc.getAddress(),row,2);
                model.setValueAt(ncc.getPhone(),row,3);
                clearForm();
            }catch(Exception e){ JOptionPane.showMessageDialog(frame,"Dữ liệu không hợp lệ!");}
        }else JOptionPane.showMessageDialog(frame,"Chọn NCC để sửa!");
    }

    private void deleteNCC(){
        int row = table.getSelectedRow();
        if(row>=0){
            listNCC.remove(row);
            model.removeRow(row);
            clearForm();
        }else JOptionPane.showMessageDialog(frame,"Chọn NCC để xóa!");
    }

    private void clearForm(){
        txtId.setText(""); txtName.setText(""); txtAddress.setText(""); txtPhone.setText("");
    }

    private void searchNCC(String keyword){
        DefaultTableModel searchModel = new DefaultTableModel(new String[]{"Mã NCC","Tên NCC","Địa chỉ","SĐT"},0);
        for(NhaCungCap ncc : listNCC){
            if(ncc.getSupplierName().toLowerCase().contains(keyword.toLowerCase())){
                searchModel.addRow(new Object[]{ncc.getSupplierId(),ncc.getSupplierName(),ncc.getAddress(),ncc.getPhone()});
            }
        }
        table.setModel(searchModel);
    }
}
