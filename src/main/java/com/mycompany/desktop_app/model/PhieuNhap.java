package com.mycompany.desktop_app.model;

import java.util.Date;

/**
 * Purchase Order entity class
 */
public class PhieuNhap {
    private int phieuNhapId;
    private int supplierId;  // foreign key to NhaCungCap
    private Date ngayNhap;
    private float tongTien;
    private String status;

    // Constructor
    public PhieuNhap() {}

    public PhieuNhap(int phieuNhapId, int supplierId, Date ngayNhap, float tongTien, String status) {
        this.phieuNhapId = phieuNhapId;
        this.supplierId = supplierId;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.status = status;
    }

    // GETTER
    public int getPhieuNhapId() { return phieuNhapId; }
    public int getSupplierId() { return supplierId; }
    public Date getNgayNhap() { return ngayNhap; }
    public float getTongTien() { return tongTien; }
    public String getStatus() { return status; }

    // SETTER
    public void setPhieuNhapId(int phieuNhapId) { this.phieuNhapId = phieuNhapId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public void setNgayNhap(Date ngayNhap) { this.ngayNhap = ngayNhap; }
    public void setTongTien(float tongTien) { this.tongTien = tongTien; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "PhieuNhap{" + "phieuNhapId=" + phieuNhapId + ", supplierId=" + supplierId +
               ", ngayNhap=" + ngayNhap + ", tongTien=" + tongTien +
               ", status=" + status + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhieuNhap other = (PhieuNhap) obj;
        return phieuNhapId == other.phieuNhapId;
    }
}
