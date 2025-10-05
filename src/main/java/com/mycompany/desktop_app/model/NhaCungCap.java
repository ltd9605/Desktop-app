package com.mycompany.desktop_app.model;

/**
 * Supplier entity class
 */
public class NhaCungCap {
    private int supplierId;
    private String supplierName;
    private String phone;
    private String address;
    private String email;
    private String status;

    // Constructor
    public NhaCungCap() {}

    public NhaCungCap(int supplierId, String supplierName, String phone,
                       String address, String email, String status) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.status = status;
    }

    // GETTER
    public int getSupplierId() { return supplierId; }
    public String getSupplierName() { return supplierName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }

    // SETTER
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "NhaCungCap{" + "supplierId=" + supplierId + ", supplierName=" + supplierName +
               ", phone=" + phone + ", address=" + address + ", email=" + email +
               ", status=" + status + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NhaCungCap other = (NhaCungCap) obj;
        return supplierId == other.supplierId;
    }
}
