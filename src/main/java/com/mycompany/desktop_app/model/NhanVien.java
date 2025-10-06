package com.mycompany.desktop_app.model;

/**
 * Lớp thực thể Nhân Viên
 * @author duysenpai234
 */
public class NhanVien {
    private int maNhanVien;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String tenDangNhap;
    private String matKhau; 
    private String vaiTro; 

    // Phương thức khởi tạo
    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String hoTen, String soDienThoai, String diaChi, String tenDangNhap, String matKhau, String vaiTro) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    // GETTERS
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    // SETTERS
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        // Không nên hiển thị mật khẩu trong toString() để tránh lộ thông tin nhạy cảm khi ghi log
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", tenDangNhap=" + tenDangNhap + ", vaiTro=" + vaiTro + '}';
    }
}