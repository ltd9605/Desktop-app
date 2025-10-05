package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.Customer;
import static java.awt.Color.GRAY;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duysenpai234
 */
public class CustomerForm {
    JFrame frame;
    
    // Khởi tạo dữ liệu mẫu
    public ArrayList<Customer> InitCustomerList() {
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyễn Văn An", "0912345678", "an.nv@email.com", "123 Đường ABC, Quận 1, TP.HCM"));
        customerList.add(new Customer(2, "Trần Thị Bình", "0987654321", "binh.tt@email.com", "456 Đường XYZ, Quận 3, TP.HCM"));
        customerList.add(new Customer(3, "Lê Văn Cường", "0905123123", "cuong.lv@email.com", "789 Đường DEF, Quận Gò Vấp, TP.HCM"));
        customerList.add(new Customer(4, "Phạm Thị Dung", "0334567890", "dung.pt@email.com", "101 Đường GHI, TP. Thủ Đức, TP.HCM"));
        customerList.add(new Customer(5, "Hoàng Văn Em", "0778889990", "em.hv@email.com", "222 Đường JKL, Quận 7, TP.HCM"));
         customerList.add(new Customer(6, "Võ Thị Gái", "0944112233", "gai.vt@email.com", "333 Đường MNO, Quận Bình Thạnh, TP.HCM"));
         customerList.add(new Customer(7, "Đinh Quang Hùng", "0888999777", "hung.dq@email.com", "444 Đường PQR, Quận 10, TP.HCM"));

        return customerList;
    }

    public CustomerForm() {
        frame = new JFrame("Quản lý Khách hàng");
        frame.setLayout(null);
        frame.setSize(600, 400);

        JLabel title = new JLabel("Danh sách khách hàng:");
        title.setBounds(20, 20, 200, 20);
        frame.add(title);

        JButton addCustomerBtn = new JButton("Thêm khách hàng");
        addCustomerBtn.setBounds(450, 20, 130, 20);
        frame.add(addCustomerBtn);

        JPanel containerPn = new JPanel();
        containerPn.setBounds(20, 60, 560, 240);
        containerPn.setLayout(null);
        containerPn.setBackground(GRAY);

        JTextField searchTxt = new JTextField("Nhập tên khách hàng");
        searchTxt.setBounds(10, 10, 150, 20);
        containerPn.add(searchTxt);

        JButton searchBtn = new JButton("Tìm kiếm");
        searchBtn.setBounds(170, 10, 100, 20);
        containerPn.add(searchBtn);

        ArrayList<Customer> cList = InitCustomerList();
        String[] columnNames = {"ID", "Họ Tên", "SĐT", "Email", "Địa chỉ"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Customer c : cList) {
            Object[] row = {
                c.getCustomerId(),
                c.getFullName(),
                c.getPhoneNumber(),
                c.getEmail(),
                c.getAddress()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(0, 40, 560, 200);
        containerPn.add(sc);
        
        frame.add(containerPn);

        JButton editBtn = new JButton("Sửa");
        editBtn.setBounds(370, 320, 100, 20);
        frame.add(editBtn);
        
        JButton deleteBtn = new JButton("Xóa");
        deleteBtn.setBounds(480, 320, 100, 20);
        frame.add(deleteBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}