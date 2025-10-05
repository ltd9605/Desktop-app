package com.mycompany.desktop_app.model;

/**
 * Customer entity class
 * @author duysenpai234
 */
public class Customer {
    private int customerId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructors
    public Customer() {
    }

    public Customer(int customerId, String fullName, String phoneNumber, String email, String address) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // GETTERS
    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // SETTERS
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + '}';
    }
}