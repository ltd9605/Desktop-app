package com.mycompany.desktop_app.model;

/**
 * Lớp thực thể Khách Hàng
 * @author duysenpai234
 */
public class KhachHang {
    private int maKhachHang;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String diaChi;

    // Phương thức khởi tạo
    public KhachHang() {
    }

    public KhachHang(int maKhachHang, String hoTen, String soDienThoai, String email, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    // GETTERS
    public int getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // SETTERS
    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + '}';
    }
}