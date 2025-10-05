package com.mycompany.desktop_app.ui;

import com.mycompany.desktop_app.model.Employee;
import static java.awt.Color.GRAY;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class EmployeeForm {
    JFrame frame;

    // Khởi tạo dữ liệu mẫu
    public ArrayList<Employee> InitEmployeeList() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Lê Trần Duy", "0905111222", "72 Nguyễn Huệ, Quận 1, TP.HCM", "duyadmin", "admin@123", "Quản lý"));
        employeeList.add(new Employee(2, "Bùi Văn Kiên", "0987123456", "111 Đường A, Quận 1, TP.HCM", "kienbv", "pass123", "Nhân viên"));
        employeeList.add(new Employee(3, "Ngô Thị My", "0909456789", "222 Đường B, Quận 3, TP.HCM", "mynt", "pass123", "Nhân viên"));
        employeeList.add(new Employee(4, "Đặng Văn Long", "0933789123", "333 Đường C, Quận 5, TP.HCM", "longdv", "pass123", "Nhân viên"));
        employeeList.add(new Employee(5, "Trần Thúy Vy", "0918123789", "444 Đường D, Quận 7, TP.HCM", "vitt", "pass123", "Nhân viên"));
        return employeeList;
    }

    public EmployeeForm() {
        frame = new JFrame("Quản lý Nhân viên");
        frame.setLayout(null);
        frame.setSize(600, 400);

        JLabel title = new JLabel("Danh sách nhân viên:");
        title.setBounds(20, 20, 200, 20);
        frame.add(title);

        JButton addEmployeeBtn = new JButton("Thêm nhân viên");
        addEmployeeBtn.setBounds(450, 20, 130, 20);
        frame.add(addEmployeeBtn);

        JPanel containerPn = new JPanel();
        containerPn.setBounds(20, 60, 560, 240);
        containerPn.setLayout(null);
        containerPn.setBackground(GRAY);

        JTextField searchTxt = new JTextField("Nhập tên nhân viên");
        searchTxt.setBounds(10, 10, 150, 20);
        containerPn.add(searchTxt);

        JButton searchBtn = new JButton("Tìm kiếm");
        searchBtn.setBounds(170, 10, 100, 20);
        containerPn.add(searchBtn);
        
        ArrayList<Employee> eList = InitEmployeeList();
        String[] columnNames = {"ID", "Họ Tên", "SĐT", "Địa chỉ", "Tên đăng nhập", "Vai trò"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Employee e : eList) {
            Object[] row = {
                e.getEmployeeId(),
                e.getFullName(),
                e.getPhoneNumber(),
                e.getAddress(),
                e.getUserName(),
                e.getRole()
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