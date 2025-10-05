package com.mycompany.desktop_app.model;

/**
 * Employee entity class
 * @author duysenpai234
 */
public class Employee {
    private int employeeId;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String userName;
    private String password; 
    private String role; 

    // Constructors
    public Employee() {
    }

    public Employee(int employeeId, String fullName, String phoneNumber, String address, String userName, String password, String role) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    // GETTERS
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // SETTERS
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", userName=" + userName + ", role=" + role + '}';
    }
}
